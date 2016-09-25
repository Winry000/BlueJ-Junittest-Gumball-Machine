

public class SoldState implements State {
 
    GumballMachine gumballMachine;
 
    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
       
    public void insertCoin(int coin) {
        System.out.println("Please wait, we're already giving you a gumball");
    }
 
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank");
    }
 
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }
 
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            while(gumballMachine.getCoins() >= 50) {
                gumballMachine.setState(gumballMachine.getHasEnoughCoin());
                gumballMachine.releaseBall();
           }
           if(gumballMachine.getCoins() < 50){
                gumballMachine.setState(gumballMachine.getNoEnoughCoin());
                gumballMachine.ejectCoin();
           } 
        }  
        if(gumballMachine.getCount() <= 0){
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setState(gumballMachine.getSoldOutState());
            gumballMachine.ejectCoin();
        }
        
    }
 
    public String toString() {
        return "dispensing a gumball";
    }
}


