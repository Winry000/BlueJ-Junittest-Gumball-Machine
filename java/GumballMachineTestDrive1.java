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
		assertEquals(false, gm1.isGumballInSlot());
		gm1.takeGumballFromSlot();
	}
	
	@Test
    public void testNoEnoughCoinCrank() {
        System.out.println("=====Test No Enough Coin to crank ======");
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.insertDime();
        gm1.turnCrank();
        assertEquals(false, gm1.isGumballInSlot());
        gm1.takeGumballFromSlot();
    }
    
    @Test
    public void testEnoughCoinCrank(){
        System.out.println("===== Test have Enough Coin to crank ====="); 
        gm1.insertQuarter();
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.insertDime();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot()); 
        gm1.takeGumballFromSlot();
        assertEquals(false, gm1.isGumballInSlot());
    }
    
    @Test
    public void testMoreCoinCrank(){
        System.out.println("===== Test have more than 50 Coins to crank ====="); 
        gm1.insertQuarter();
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.insertQuarter();
        gm1.insertQuarter();
        gm1.insertDime();
        gm1.insertQuarter();
        gm1.insertQuarter();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot()); 
        gm1.takeGumballFromSlot();
        assertEquals(false, gm1.isGumballInSlot());
    }
    
     @Test
    public void testEnoughCoinTwoCrank(){
        System.out.println("===== Test have more than 50 Coins and crank for no more than 50 coins ====="); 
        gm1.insertQuarter();
        gm1.insertQuarter();
        gm1.insertNickel();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot()); 
        gm1.insertQuarter();
        gm1.insertQuarter();
        gm1.insertDime();
        gm1.turnCrank();
        assertEquals(true, gm1.isGumballInSlot()); 
        gm1.takeGumballFromSlot();
        assertEquals(false, gm1.isGumballInSlot());
    }
}