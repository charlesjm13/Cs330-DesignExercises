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
		starbucks.addCustomer("John Doe", "Black");
		assertEquals("This customer has a rewards account. Their iD number is: 1", starbucks.lookup("John Doe"));
	}
	@Test
	void testLookup2() {
		assertEquals("This iD number is not in our system.", starbucks.lookup(0));
		starbucks.addCustomer("Kelsey James", "Sugar");
		starbucks.addCustomer("Jack Monroe", "Sugar and Cream");
		assertEquals("This customer currently has 0 purchases towards their next reward. Their coffee preference is: Sugar", starbucks.lookup(starbucks.getID("Kelsey James")));
		starbucks.swipe(starbucks.getID("Kelsey James"));
		starbucks.swipe(starbucks.getID("Kelsey James"));
		assertEquals("This customer currently has 2 purchases towards their next reward. Their coffee preference is: Sugar", starbucks.lookup(starbucks.getID("Kelsey James")));
	}
	@Test
	void testClear() {
		starbucks.addCustomer("John Doe", "Black");
		starbucks.addCustomer("Kelsey James", "Sugar");
		starbucks.addCustomer("Jack Monroe", "Sugar and Cream");
		starbucks.addCustomer("Carter Blake", "Cream");
		starbucks.addCustomer("Jane Meyer", "Sugar and Cream");
		assertEquals(5, starbucks.returnNumCus());
		starbucks.clear();
		assertEquals(0, starbucks.returnNumCus());
		assertEquals("This customer does not have a rewards account.", starbucks.lookup("John Doe"));
	}
	@Test
	void testRemoveCustomer() {
		starbucks.addCustomer("John Doe", "Black");
		starbucks.addCustomer("Kelsey James", "Sugar");
		starbucks.addCustomer("Jack Monroe", "Sugar and Cream");
		starbucks.addCustomer("Carter Blake", "Cream");
		starbucks.addCustomer("Jane Meyer", "Sugar and Cream");
		assertEquals("This customer has a rewards account. Their iD number is: 4", starbucks.lookup("Carter Blake"));
		starbucks.removeCustomer("Carter Blake", starbucks.getID("Carter Blake"));
		assertEquals("This customer does not have a rewards account.", starbucks.lookup("Carter Blake"));
	}
	@Test
	void testGetID() {
		starbucks.addCustomer("John Doe", "Black");
		starbucks.addCustomer("Kelsey James", "Sugar");
		starbucks.addCustomer("Jack Monroe", "Sugar and Cream");
		assertEquals(1, starbucks.getID("John Doe"));
		assertEquals(3, starbucks.getID("Jack Monroe"));
	}
	@Test
	void testGetPref() {
		starbucks.addCustomer("John Doe", "Black");
		starbucks.addCustomer("Kelsey James", "Sugar");
		starbucks.addCustomer("Jack Monroe", "Sugar and Cream");
		assertEquals("Black", starbucks.getPref(starbucks.getID("John Doe")));
		assertEquals("Sugar", starbucks.getPref(starbucks.getID("Kelsey James")));
	}
	@Test
	void testGetPurchases() {
		starbucks.addCustomer("Kelsey James", "Sugar");
		starbucks.addCustomer("Jack Monroe", "Sugar and Cream");
		starbucks.swipe(2);
		starbucks.swipe(2);
		assertEquals(2, starbucks.getPurchases(2));
		assertEquals(2, starbucks.getPurchases(starbucks.getID("Jack Monroe")));
		starbucks.swipe(2);
		assertEquals(0, starbucks.getPurchases(2));
		assertEquals(0, starbucks.getPurchases(starbucks.getID("Jack Monroe")));
	}
	
	//public int getPurchases(int iD)
}
