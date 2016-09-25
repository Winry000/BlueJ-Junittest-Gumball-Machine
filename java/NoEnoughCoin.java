
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
        
        gumballMachine.setCoins(gumballMachine.getCoins()  + coin);
        
        if(gumballMachine.getCoins() >= 50){
            System.out.println("Have enough coins!");
            gumballMachine.setState(gumballMachine.getHasEnoughCoin());
        }else {
            System.out.println("There has " + gumballMachine.getCoins() +" coins, There has no enough coins!");
            gumballMachine.setState(gumballMachine.getNoEnoughCoin());
        }
   
    }
    
    public void ejectCoin(){
       if(gumballMachine.getCoins() == 0){
           System.out.println("You need to inserted coins!");
       }else{
           System.out.println("The remain change "+gumballMachine.getCoins()+" coins are released");
           gumballMachine.setCoins(0);
       }
       
    }
  
    public void turnCrank() {
        System.out.println("You turned, but there's no enough coin");
     }
 
    public void dispense() {
        System.out.println("You need to pay first");
    } 
 
    public String toString() {
         return "waiting for turn of crank";
    }

}
