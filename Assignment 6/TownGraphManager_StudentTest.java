import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TownGraphManager_StudentTest {
	private TownGraphManagerInterface graph;
	private String[] town_student;
	  
	@Before
	public void setUp() throws Exception {
		  graph = new TownGraphManager();
		  town_student = new String[10];
		  
		  for (int i = 1; i < 10; i++) {
			  town_student[i] = "Town_" + i;
			  graph.addTown(town_student[i]);
		  } 
		  
		  graph.addRoad(town_student[2], town_student[4], 4, "Road_A");
		  graph.addRoad(town_student[1], town_student[3], 3, "Road_B");
		  graph.addRoad(town_student[4], town_student[5], 6, "Road_C");
		  graph.addRoad(town_student[2], town_student[8], 2, "Road_D");
		  graph.addRoad(town_student[5], town_student[9], 6, "Road_E");
		  graph.addRoad(town_student[2], town_student[6], 1, "Road_F");
		  graph.addRoad(town_student[5], town_student[7], 2, "Road_G");
		  graph.addRoad(town_student[8], town_student[5],7, "Road_H");
		  graph.addRoad(town_student[7], town_student[4], 1, "Road_I");
		  graph.addRoad(town_student[3], town_student[7], 4, "Road_J");
		 
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testAddRoad() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_A", roads.get(0));
		assertEquals("Road_B", roads.get(1));
		assertEquals("Road_C", roads.get(2));
		assertEquals("Road_D", roads.get(3));
		graph.addRoad(town_student[2], town_student[9], 1,"Road_Z");
		roads = graph.allRoads();
		assertEquals("Road_A", roads.get(0));
		assertEquals("Road_B", roads.get(1));
		assertEquals("Road_C", roads.get(2));
		assertEquals("Road_E", roads.get(4));
		assertEquals("Road_Z", roads.get(10));
		
	}

	@Test
	public void testGetRoad() {
		assertEquals("Road_G", graph.getRoad(town_student[5], town_student[7]));
		assertEquals("Road_J", graph.getRoad(town_student[3], town_student[7]));
	}

	@Test
	public void testAddTown() {
		assertEquals(false, graph.containsTown("Town_V"));
		graph.addTown("Town_V");
		assertEquals(true, graph.containsTown("Town_V"));
		assertEquals(false, graph.containsTown("Town_Y"));
		graph.addTown("Town_Y");
		assertEquals(true, graph.containsTown("Town_Y"));
	}
	
	@Test
	public void testDisjointGraph() {
		assertEquals(false, graph.containsTown("Town_K"));
		graph.addTown("Town_K");
		ArrayList<String> path = graph.getPath(town_student[2],"Town_K");
		assertFalse(path.size() > 0);
	}

	@Test
	public void testContainsTown() {
		assertEquals(true, graph.containsTown("Town_6"));
		assertEquals(false, graph.containsTown("Town_16"));
		assertEquals(true, graph.containsTown("Town_2"));
		assertEquals(false, graph.containsTown("Town_77"));
	}

	@Test
	public void testContainsRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town_student[1], town_student[3]));
		assertEquals(false, graph.containsRoadConnection(town_student[3], town_student[5]));
		assertEquals(true, graph.containsRoadConnection(town_student[7], town_student[4]));
		assertEquals(false, graph.containsRoadConnection(town_student[4], town_student[9]));
	}

	@Test
	public void testAllRoads() {
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_A", roads.get(0));
		assertEquals("Road_B", roads.get(1));
		assertEquals("Road_C", roads.get(2));
		assertEquals("Road_I", roads.get(8));
		assertEquals("Road_J", roads.get(9));
	}

	@Test
	public void testDeleteRoadConnection() {
		assertEquals(true, graph.containsRoadConnection(town_student[2], town_student[4]));
		graph.deleteRoadConnection(town_student[2], town_student[4], "Road_A");
		assertEquals(false, graph.containsRoadConnection(town_student[2], town_student[4]));
	}

	@Test
	public void testDeleteTown() {
		assertEquals(true, graph.containsTown("Town_2"));
		graph.deleteTown(town_student[2]);
		assertEquals(false, graph.containsTown("Town_2"));
	}
	
	@Test
	public void testAllTowns() {
		ArrayList<String> roads = graph.allTowns();
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_2", roads.get(1));
		assertEquals("Town_3", roads.get(2));
		assertEquals("Town_4", roads.get(3));
		assertEquals("Town_6", roads.get(5));
		assertEquals("Town_7", roads.get(6));
	}

	@Test
	public void testGetPath() {
		ArrayList<String> path = graph.getPath(town_student[1],town_student[9]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_B to Town_3 3 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road_J to Town_7 4 mi",path.get(1).trim());

	}
	
	@Test
	public void testGetPathA() {
		ArrayList<String> path = graph.getPath(town_student[1],town_student[7]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_1 via Road_B to Town_3 3 mi",path.get(0).trim());
		  assertEquals("Town_3 via Road_J to Town_7 4 mi",path.get(1).trim());
	}
	
	@Test
	public void testGetPathB() {
		ArrayList<String> path = graph.getPath(town_student[3],town_student[9]);
		  assertNotNull(path);
		  assertTrue(path.size() > 0);
		  assertEquals("Town_3 via Road_J to Town_7 4 mi",path.get(0).trim());
		  assertEquals("Town_7 via Road_G to Town_5 2 mi",path.get(1).trim());
		  assertEquals("Town_5 via Road_E to Town_9 6 mi",path.get(2).trim());
	}

}