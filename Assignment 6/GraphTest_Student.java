import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GraphTest_Student {
	private GraphInterface<Town,Road> graph;
	private Town[] town_student;

	@Before
	public void setUp() throws Exception {
		 graph = new Graph();
		 town_student = new Town[10];
		  
		  for (int i = 1; i < 10; i++) {
			  town_student[i] = new Town("Town_" + i);
			  graph.addVertex(town_student[i]);
		  }
		  
		  graph.addEdge(town_student[2], town_student[4], 4, "Road_A");
		  graph.addEdge(town_student[1], town_student[3], 3, "Road_B");
		  graph.addEdge(town_student[4], town_student[5], 6, "Road_C");
		  graph.addEdge(town_student[2], town_student[8], 2, "Road_D");
		  graph.addEdge(town_student[5], town_student[9], 6, "Road_E");
		  graph.addEdge(town_student[2], town_student[6], 1, "Road_F");
		  graph.addEdge(town_student[5], town_student[7], 2, "Road_G");
		  graph.addEdge(town_student[8], town_student[5],7, "Road_H");
		  graph.addEdge(town_student[7], town_student[4], 1, "Road_I");
		  graph.addEdge(town_student[3], town_student[7], 4, "Road_J");
	}

	@After
	public void tearDown() throws Exception {
		graph = null;
	}

	@Test
	public void testGetEdge() {
		assertEquals(new Road(town_student[2], town_student[4],4, "Road_A"), graph.getEdge(town_student[2], town_student[4]));
		assertEquals(new Road(town_student[3], town_student[7],7, "Road_G"), graph.getEdge(town_student[3], town_student[7]));
	}

	@Test
	public void testAddEdge() {
		assertEquals(false, graph.containsEdge(town_student[2], town_student[9]));
		graph.addEdge(town_student[2], town_student[9], 8, "Road_D");
		assertEquals(true, graph.containsEdge(town_student[2], town_student[9]));
	}

	@Test
	public void testAddVertex() {
		Town newTown = new Town("Town_J");
		assertEquals(false, graph.containsVertex(newTown));
		graph.addVertex(newTown);
		assertEquals(true, graph.containsVertex(newTown));
	}

	@Test
	public void testContainsEdge() {
		assertEquals(true, graph.containsEdge(town_student[5], town_student[5]));
		assertEquals(false, graph.containsEdge(town_student[2], town_student[9]));
		assertEquals(true, graph.containsEdge(town_student[8], town_student[5]));
		assertEquals(false, graph.containsEdge(town_student[1], town_student[7]));
	}

	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_5")));
		assertEquals(false, graph.containsVertex(new Town("Town_15")));
		assertEquals(false, graph.containsVertex(new Town("Town_50")));
		assertEquals(true, graph.containsVertex(new Town("Town_1")));

	}

	@Test
	public void testEdgeSet() {
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_A", roadArrayList.get(0));
		assertEquals("Road_B", roadArrayList.get(1));
		assertEquals("Road_C", roadArrayList.get(2));
		assertEquals("Road_D", roadArrayList.get(3));
		assertEquals("Road_E", roadArrayList.get(4));
		assertEquals("Road_G", roadArrayList.get(6));
		assertEquals("Road_J", roadArrayList.get(9));
	}

	@Test
	public void testEdgesOf() {
		Set<Road> std_roads = graph.edgesOf(town_student[2]);
		ArrayList<String> std_roadArrayList = new ArrayList<String>();
		for(Road road : std_roads)
			std_roadArrayList.add(road.getName());
		Collections.sort(std_roadArrayList);
		assertEquals("Road_A", std_roadArrayList.get(0));
		assertEquals("Road_D", std_roadArrayList.get(1));
		assertEquals("Road_F", std_roadArrayList.get(2));
	}
	
	@Test
	public void testRemoveEdge() {
		assertEquals(true, graph.containsEdge(town_student[1], town_student[3]));
		graph.removeEdge(town_student[4], town_student[5], 6, "Road_C");
		assertEquals(false, graph.containsEdge(town_student[4], town_student[5]));
	}
	
	@Test
	public void testRemoveVertex() {
		assertEquals(true, graph.containsVertex(town_student[2]));
		graph.removeVertex(town_student[2]);
		assertEquals(false, graph.containsVertex(town_student[2]));
	}

	@Test
	public void testVertexSet() {
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town_student[1]));
		assertEquals(true, roads.contains(town_student[9]));
		assertEquals(true, roads.contains(town_student[7]));
		assertEquals(true, roads.contains(town_student[2]));
		assertEquals(true, roads.contains(town_student[3]));
	}

	 @Test
	  public void testTown_2ToTown_9() {
		  String beginTown = "Town_2", endTown = "Town_9";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			 
			  assertEquals("Town_2 via Road_A to Town_4 4 mi",path.get(0).trim());
			  assertEquals("Town_4 via Road_I to Town_7 1 mi",path.get(1).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
	  
	  
	  @Test
	  public void testTown1ToTown_9() {
		  String beginTown = "Town_1", endTown = "Town_9";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  assertEquals("Town_1 via Road_B to Town_3 3 mi",path.get(0).trim());
			  assertEquals("Town_3 via Road_J to Town_7 4 mi",path.get(1).trim());
			  assertEquals("Town_5 via Road_E to Town_9 6 mi",path.get(3).trim());
		  }
		
		  else
			  fail("Town names are not valid");

	  }
	  
	  @Test
	  public void testTown_5ToTown_9() {
		  String beginTown = "Town_5", endTown = "Town_9";
		  Town beginIndex=null, endIndex=null;
		  Set<Town> towns = graph.vertexSet();
		  Iterator<Town> iterator = towns.iterator();
		  while(iterator.hasNext())
		  {    	
			  Town town = iterator.next();
			  if(town.getName().equals(beginTown))
				  beginIndex = town;
			  if(town.getName().equals(endTown))
				  endIndex = town;		
		  }
		  if(beginIndex != null && endIndex != null)
		  {

			  ArrayList<String> path = graph.shortestPath(beginIndex,endIndex);
			  assertNotNull(path);
			  assertTrue(path.size() > 0);
			  			 
			  assertEquals("Town_5 via Road_E to Town_9 6 mi",path.get(0).trim());
			  //assertEquals("Town_1 via Road_B to Town_5 2 mi",path.get(1).trim());
			  //assertEquals("Town_5 via Road_C to Town_5 3 mi",path.get(2).trim());
		  }
		  else
			  fail("Town names are not valid");

	  }
}