import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GumballMachineTestDrive1 {

	private GumballMachine gm1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception { gm1 = new GumballMachine(5); 
	}
	
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testNoCoinCrank() {
		System.out.println("====No coin, and crank====");
		gm1.turnCrank();
		assertEquals(true, gm1.isGumballInSlot());
		gm1.takeGumballFromSlot();
	}
	@Test
	public void testNoCoinCrank() {
		System.out.println("====No coin, and crank====");
		gm1.insertDime();
		assertEquals(true, gm1.isGumballInSlot());
		gm1.takeGumballFromSlot();
	}
	
}