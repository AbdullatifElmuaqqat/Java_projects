import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_Student_Test {
	private Town town1;
	private Town town2;
	private Town town3;

	private Road road1;
	private Road road2;
	private Road road3;

	@BeforeEach
	void setUp() throws Exception {
		town1 = new Town("Rockville");
	    town2 = new Town("Gaithersburg");
	    town3 = new Town("Silver Spring");
	    
	    road1 = new Road(town1, town2, 5, "DeerPark");
	    road2 = new Road(town2, town3, 8, "FredreickAve");
	    road3 = new Road(town1, town3, 4, "MCRoad");

	}

	@AfterEach
	void tearDown() throws Exception {
		town1 = town2 = town3 = null;
		road1 = road2 = road3 = null;
	}


	@Test
	public void testgetName() {
		assertEquals("Rockville", town1.getName());
		assertEquals("DeerPark", road1.getName());
		assertEquals("Silver Spring", town3.getName());
		assertEquals("MCRoad", road3.getName());

	}
	
	@Test
	public void testgetWeight() {
		assertEquals(5, road1.getWeight());
		assertEquals(4, road3.getWeight());

	}
	
	@Test
	public void testgetSource() {
		assertTrue(road1.getSource().getName().equals("Rockville"));
		assertTrue(road2.getSource().getName().equals("Gaithersburg"));
		assertTrue(road3.getSource().getName().equals("Rockville"));
//		assertEquals("Town: Gaithersburg", road2.getSource());
//		assertEquals("Town: Silver Spring", road3.getSource());

	}
	
	
	@Test
	public void testgetDestination() {
		assertTrue(road1.getDestination().getName().equals("Gaithersburg"));
		assertTrue(road2.getDestination().getName().equals("Silver Spring"));
		assertTrue(road3.getDestination().getName().equals("Silver Spring"));
//		assertEquals("Town: Gaithersburg", road1.getDestination());
//		assertEquals("Town: Silver Spring", road1.getDestination());
//		assertEquals("Town: Rockville", road1.getDestination());
	}
	
	@Test
	public void testcompareTo() {
		Road road4 = new Road(town1, town2, 5, "DeerPark");
		//Road road5 = new Road(town1, town2, 5, "Road1");

		assertTrue(road1.compareTo(road4) == 0);
		assertTrue(road2.compareTo(road3) < 1);
		assertTrue(road3.compareTo(road4) > 1);
	}
	
	@Test
	public void testequals() {
		Road road4 = new Road(town1, town2, 5, "DeerPark");
		Road road5 = new Road(town2, town3, 5, "Road1");
		assertTrue(road4.equals(road1));
		assertFalse(road1.equals(road5));
		assertFalse(road2.equals(road3));
	}
	
	@Test
	public void testContains() {
		Road road4 = new Road(town1, town2, 5, "DeerPark");
		assertTrue(road4.contains(town1));
		assertTrue(road1.contains(town2));
		assertTrue(road3.contains(town3));
		assertFalse(road1.contains(town3));


	}
	
	@Test
	public void testtoString() {
		assertEquals("Road: DeerPark, connecting Rockville to Gaithersburg by 5 mi", road1.toString());
		assertEquals("Road: FredreickAve, connecting Gaithersburg to Silver Spring by 8 mi", road2.toString());
	}

}
