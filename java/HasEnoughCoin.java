
import java.util.Random;
public class HasEnoughCoin implements State
{
   GumballMachine gumballMachine;
 
    public HasEnoughCoin(GumballMachine gumballMachine) {
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
        }
        /*else {
            System.out.println("There has " + gumballMachine.getCoins() +" coins, There has no enough coins!");
            gumballMachine.setState(gumballMachine.getNoEnoughCoin());
        }*/
        /*gumballMachine.setState(gumballMachine.getHasEnoughCoin());*/
    }
 
    public void ejectCoin() {
       if(gumballMachine.getCoins() == 0){
           System.out.println("You need to inserted coins!");
       }else{
           System.out.println("There are "+gumballMachine.getCoins()+"coins left");
           gumballMachine.setCoins(0);
       }
    }
 
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "waiting for turn of crank";
    }
}
