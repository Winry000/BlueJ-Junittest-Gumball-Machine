

public class SoldOutState implements State {
    GumballMachine gumballMachine;
 
    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
    public void insertCoin(int coin) {
        System.out.println("You can't insert a coin, the machine is sold out");
    }
 
    public void ejectCoin() {
       if(gumballMachine.getCoins() == 0){
           System.out.println("You can't eject, you haven't inserted a coin yet");
       }else{
           System.out.println("The remain change "+gumballMachine.getCoins()+" coins are released");
           gumballMachine.setCoins(0);
        }
    }
 
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }
 
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
    public String toString() {
        return "sold out";
    }
}
