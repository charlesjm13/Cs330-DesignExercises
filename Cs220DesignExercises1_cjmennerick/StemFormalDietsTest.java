import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StemFormalDietsTest {

	DietDatabase<String, String> stem;
	
	@BeforeEach
	public void setUp() {
		stem = new StemFormalDiets();
	}
	
	@Test
	void testAdd() {
		assertEquals(0, stem.size());
		stem.add("Thomas", "Vegetarian");
		assertEquals(1, stem.size());
		stem.add("Jane", "Vegan");
		assertEquals(2, stem.size());
		assertEquals("Vegan", stem.getDiet("Jane"));
		assertEquals("Vegetarian", stem.getDiet("Thomas"));
	}
	@Test
	void testChange() {
		assertEquals(0, stem.size());
		stem.add("Thomas", "Vegetarian");
		assertEquals(1, stem.size());
		stem.add("Jane", "Vegan");
		assertEquals(2, stem.size());
		assertEquals("Vegan", stem.getDiet("Jane"));
		assertEquals("Vegetarian", stem.getDiet("Thomas"));
		stem.change("Thomas", "Vegan");
		assertEquals("Vegan", stem.getDiet("Thomas"));
		stem.change("Jake", "Non-Vegetarian");
		assertEquals("Non-Vegetarian", stem.getDiet("Jake"));
	}
	
	@Test
	void testClear() {
		assertEquals(0, stem.size());
		stem.add("Thomas", "Vegetarian");
		assertEquals(1, stem.size());
		stem.add("Jane", "Vegan");
		assertEquals(2, stem.size());
		stem.clear();
		assertEquals(0, stem.size());
		
	}
	@Test
	void testContains() {
		assertEquals(false, stem.contains("Jane"));
		stem.add("Jane", "Vegan");
		assertEquals(true, stem.contains("Jane"));
	}
	
	@Test
	void testGetDiet() {
		stem.add("Mark", "Vegetarian");
		assertEquals("Vegetarian", stem.getDiet("Mark"));
	}
	
	@Test
	void testRemove() {
		assertEquals(0, stem.size());
		stem.add("Thomas", "Vegetarian");
		assertEquals(1, stem.size());
		stem.add("Jane", "Vegan");
		assertEquals(2, stem.size());
		stem.remove("Jane");
		assertEquals(1, stem.size());
		stem.remove("Thomas");
		assertEquals(0, stem.size());
	}
	
	@Test
	void testReturnAll() {
		stem.add("James", "Vegetarian");
		stem.add("John", "Vegan");
		stem.add("Courtney", "Vegan");
		stem.add("Blane", "Vegan");
		stem.add("Cynthia", "Vegetarian");
		stem.add("Michelle", "Pescatarian");
		stem.add("Bruce", "Vegetarian");
		stem.add("Harley", "Non-Vegetarian");
		stem.add("Christie", "Pescatarian");
		assertEquals("Blane", stem.returnAll("Vegan")[0]);
		assertEquals("Courtney", stem.returnAll("Vegan")[1]);
		assertEquals("John", stem.returnAll("Vegan")[2]);
		
	}
	
	@Test
	void testSize() {
		assertEquals(0, stem.size());
		stem.add("Thomas", "Vegetarian");
		assertEquals(1, stem.size());
		stem.add("Jane", "Vegan");
		assertEquals(2, stem.size());
		
	}
	

}
