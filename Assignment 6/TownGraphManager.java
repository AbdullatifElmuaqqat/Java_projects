import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class TownGraphManager implements TownGraphManagerInterface {

	Graph grph = new Graph();

	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
			Road addrd;
		 	Town tow1 = new Town(town1);
	        Town tow2 = new Town(town2);

	        grph.addVertex(tow1);
	        grph.addVertex(tow2);
	        
	        addrd = grph.addEdge(tow1, tow2, weight, roadName);
	        
	        if(addrd != null){

	        	return true;
		}
		else 
			return false;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	
	@Override
	public String getRoad(String town1, String town2) {
		Road road= grph.getEdge(new Town(town1), new Town(town2));
		if(road != null) {
			return road.getName();
			
		}
		return null;
	}
	
	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	
	@Override
	public boolean addTown(String v) {
		return grph.addVertex(new Town (v));
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	
	@Override
	public Town getTown(String name) {
		Town town = null;
		Set<Town> twn = grph.vertexSet();
		for(Town towns : twn) {
			if(towns.getName().equals(name)) {
				
				return town;
			}
//			else {
//				return null;
//		}
//		}
		
		}
//		return town;
		return null;
	}
	
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	
	@Override
	public boolean containsTown(String v) {
		return grph.containsVertex(new Town (v));
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return grph.containsEdge(new Town (town1), new Town (town2));
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<Road> road = new ArrayList<Road>(grph.edgeSet());
		ArrayList<String> str = new ArrayList<>();
		
		for(Road rod : road) {
			str.add(rod.getName());
		}
		Collections.sort(str);
		return str;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Road r=grph.getEdge(new Town(town1), new Town(town2));
		Road r1=grph.removeEdge(new Town (town1), new Town (town2), r.getWeight(), road);
		if( r1!= null) {
			return true;
		}
		 
			return false;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	
	@Override
	public boolean deleteTown(String v) {
		return grph.removeVertex(new Town (v));
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<Town> towns = new ArrayList<Town>(grph.vertexSet());
		ArrayList<String> str= new ArrayList<String>();
		for(Town t: towns) {
			str.add(t.getName());
		}
		Collections.sort(str);
		return str;
		
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return grph.shortestPath(new Town (town1), new Town(town2));
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException {
		String[] t;
		String str;

		Scanner fileScanner = new Scanner(selectedFile);

		while (fileScanner.hasNextLine()) {
			str = fileScanner.nextLine();
			t = str.split(",|;");
			grph.addVertex(new Town(t[2]));
			grph.addVertex(new Town(t[3]));
			grph.addEdge(new Town(t[2]), new Town(t[3]), Integer.parseInt(t[1]), t[0]);
		}
		fileScanner.close();
	
	}
}