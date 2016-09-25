
public class NoEnoughCoin implements State
{
    GumballMachine gumballMachine;
 
    public NoEnoughCoin(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertCoin(int coin) {
        if(coin == 5){
            System.out.println("You inserted a nickel!");
        } else if(coin == 10){
           System.out.println("You inserted a dime!");
        } else if(coin == 25){
           System.out.println("You inserted a quarter!");
        }
        
        if(gumballMachine.getCoins() >= 50){
            System.out.println("Have enough coins!");
            gumballMachine.setState(gumballMachine.getHasEnoughCoin());
        }else {
            System.out.println("There has no enough coins!");
            gumballMachine.setState(gumballMachine.getNoEnoughCoin());
        }
        gumballMachine.setState(gumballMachine.getHasEnoughCoin());
    }
    
    public void ejectCoin(){
       if(gumballMachine.getCoins() == 0){
           System.out.println("You need to inserted coins!");
       }else{
           System.out.println("There are"+gumballMachine.getCoins()+"coins left");
           gumballMachine.setCoins(0);
       }
       
    }
  
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
     }
 
    public void dispense() {
        System.out.println("You need to pay first");
    } 
 
    public String toString() {
        return "waiting for quarter";
    }

}
