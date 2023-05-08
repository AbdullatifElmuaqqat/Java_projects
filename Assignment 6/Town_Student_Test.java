import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_Student_Test {

	private Town town1;
	private Town town2;
	private Town town3;

	
	
	@BeforeEach
	void setUp() throws Exception {
		    town1 = new Town("Rockville");
		    town2 = new Town("Gaithersburg");
		    town3 = new Town("Silver Spring");
		    
	
	}

	@AfterEach
	void tearDown() throws Exception {
		town1 = town2 = town3 = null;
	}

	@Test
	public void testgetName() {
		assertEquals("Rockville", town1.getName());
		assertEquals("Silver Spring", town3.getName());
	}
	
	@Test
	public void testequals() {
		Town town4 = new Town("Rockville");
		Town town5 = new Town("Germantown");
		assertTrue(town1.equals(town4));
		assertFalse(town2.equals(town5));
	}
	
	@Test
	public void testcomparTo() {
		Town town4 = new Town("Rockville");
		Town town5 = new Town("Germantown");
		assertTrue(town1.compareTo(town4)== 0);
		assertTrue(town2.compareTo(town1) < 1);
		assertTrue(town5.compareTo(town2) > 1);
	}
	
	@Test
	public void testhashcode() {
		Town town4 = new Town("Rockville");
		Town town5 = new Town("Germantown");
		assertEquals(town1.hashCode(), town4.hashCode());
		assertNotEquals(town3.hashCode(), town5.hashCode());
	}
	
	@Test
	public void testtoString() {
		Town town5 = new Town("Germantown");
		assertEquals("Gaithersburg", town2.toString());
		assertEquals("Germantown", town5.toString());
	}
}
