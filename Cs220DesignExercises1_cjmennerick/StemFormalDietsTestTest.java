import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StemFormalDietsTestTest {
	
	DietDatabase<String, String> stem;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		stem = new StemFormalDiets();
	}

	@Test
	void test() {
		assertEquals(0, stem.size());
		stem.add("Thomas", "Vegetarian");
		assertEquals(1, stem.size());
		stem.add("Jane", "Vegan");
		assertEquals(2, stem.size());
	}

}
