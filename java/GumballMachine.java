

public class GumballMachine {
 
    State soldOutState;
    State noEnoughCoinState;
    State hasEnoughCoinState;
    State soldState;
 
    State state = soldOutState;
    int count = 0;
    int coin = 0;
    int slot = 0;
 
    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this); //creat child class object to implement ploymorphism
        noEnoughCoinState = new NoEnoughCoin(this);
        hasEnoughCoinState = new HasEnoughCoin(this);
        soldState = new SoldState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noEnoughCoinState;
        } else {
            state = soldOutState;
        }
    }
 
    public void insertNickel() {
        state.insertCoin(5);
    }
    
    public void insertDime() {
        state.insertCoin(10);
    }
    
    public void insertQuarter() {
        state.insertCoin(25);
    }
 
    public void ejectCoin() {
        state.ejectCoin();
    }
 
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }
 
    void releaseBall() {
        if(count != 0)
            count = count -1;
        coin = coin - 50;
        slot = slot + 1;
        System.out.println("A gumball is rolling out the slot...");
    }
 
    int getCount() {
        return count;
    }
    
    void setCoins(int x) {
        coin = x;
    }
    
    int getCoins(){
        return coin;
    }
    
    void refill(int count) {
        this.count = count;
        state = noEnoughCoinState;
    }

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoEnoughCoin() {
        return noEnoughCoinState;
    }

    public State getHasEnoughCoin() {
        return hasEnoughCoinState;
    }

    public State getSoldState() {
        return soldState;
    }
    
    public boolean isGumballInSlot() {
        if(slot == 0) {
            System.out.println("There is no gumball in slot");
            return false;
        }else if (slot == 1){
            System.out.println("There one gumball in slot");
        }else {
            System.out.println("There have " + slot + " gumballs in slot");
        }
        return true;
    }   
    
    public void takeGumballFromSlot() {
        if(slot > 0) {
           System.out.println("Please pick up " + slot + " gumball/gumballs");
           slot = 0;
        } else if(slot == 0) {
           System.out.println("There has no gumball to pick up");
        }
    }
    
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004");
        result.append("\nInventory: " + count + " gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is " + state + "\n");
        return result.toString();
    }
}
