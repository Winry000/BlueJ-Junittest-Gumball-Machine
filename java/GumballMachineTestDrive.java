

public class GumballMachineTestDrive {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertDime();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		
		gumballMachine.isGumballInSlot();
		gumballMachine.takeGumballFromSlot();
		gumballMachine.isGumballInSlot();

		System.out.println(gumballMachine);

		gumballMachine.insertNickel();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
