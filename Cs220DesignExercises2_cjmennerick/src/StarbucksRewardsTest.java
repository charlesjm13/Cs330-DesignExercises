import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StarbucksRewardsTest {
	
	CoffeeShopInterface starbucks;

	@BeforeEach
	void setUp() {
		starbucks = new StarbucksRewards();
	}

	@Test
	void testAddCustomer() {
		starbucks.addCustomer("John Doe", "Black");
		assertEquals(1, starbucks.returnNumCus());
		starbucks.addCustomer("Kelsey James", "Sugar");
		starbucks.addCustomer("Jack Monroe", "Sugar and Cream");
		starbucks.addCustomer("Carter Blake", "Cream");
		starbucks.addCustomer("Jane Meyer", "Sugar and Cream");
		assertEquals(5, starbucks.returnNumCus());
	}
	
	@Test
	void testChangePref() {
		starbucks.addCustomer("John Doe", "Black");
		assertEquals("Black", starbucks.getPref(starbucks.getID("John Doe")));
		starbucks.addCustomer("Jane Doe", "Black");
		assertEquals("Black", starbucks.getPref(starbucks.getID("Jane Doe")));
		starbucks.changePref("John Doe", "Sugar");
		starbucks.changePref("Jane Doe", "Cream");
		assertEquals("Sugar", starbucks.getPref(starbucks.getID("John Doe")));
		assertEquals("Cream", starbucks.getPref(starbucks.getID("Jane Doe")));
	}
	
	@Test
	void testLookup1() {
		assertEquals("This customer does not have a rewards account.", starbucks.lookup("James Kelly"));
		
	}
	//public void lookup(String name); 
	//public void lookup(int iD);		
	//public void clear();	
	//public void removeCustomer(String name, int iD);

}
