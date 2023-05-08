import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town,Road>{

	private HashMap<Town,Town> prev;//weight
	private HashMap<Town,Integer> distance;//townMap
	private HashSet<Town> town;
	private HashSet<Road> road;
	
	
	public Graph() {
		prev = new HashMap<Town,Town>();
		distance = new HashMap<Town, Integer>();
		town = new HashSet<Town>();
		road = new HashSet<Road>();
	}

	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		if(sourceVertex == null || destinationVertex == null) {
			return null;
		}
		else {
			for(Road r : road) {
				if(r.contains(destinationVertex) && r.contains(sourceVertex)) {
					
					return r;
				}
				
		}
	}
		return null;
	}

	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) throws NullPointerException, IllegalArgumentException {
		if( sourceVertex== null ||  destinationVertex== null)
			throw new NullPointerException();
		if(!(town.contains(sourceVertex)||town.contains(destinationVertex))) {
			throw new IllegalArgumentException();
		}
		Road road1 = new Road(sourceVertex, destinationVertex, weight, description);
		
		try {
		road.add(road1);
		}catch(Exception e) {
			return null;
		}
		return road1;
		
	}

		

	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	
	@Override
	public boolean addVertex(Town v) throws NullPointerException {
		if(v==null) {
			throw new NullPointerException();
		}
		for(Town T: town) {
			if(T.equals(v)) {
				return false;
			}
		}
		town.add(v);
		return true;
	}

	 /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if(sourceVertex==null ||destinationVertex==null) {
			return false;
		}
		if(!(town.contains(sourceVertex) ||town.contains(destinationVertex))){
			return false;
		}
		for(Road rod:road) {
			if(rod.contains(destinationVertex) && rod.contains(sourceVertex)) {
				return true;
			}
		}
		return false;
	}

	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	
	@Override
	public boolean containsVertex(Town v) {
		for(Town t : town) {
			if(t.equals(v)) {
				return true;
			}
		}
		return false;
	}

	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	
	@Override
	public Set<Road> edgeSet() {
		HashSet<Road> newRoad = new HashSet<Road>();
		for(Road roads: road) {
			newRoad.add(roads);
			return road;
		}
		return null;
	}

	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	
	@Override
	public Set<Road> edgesOf(Town vertex) throws IllegalArgumentException,NullPointerException {
		HashSet<Road> rde = new HashSet<Road>();
		for(Road r:road) {
			if(r.contains(vertex)) {
				rde.add(r);
			}
		}
		return rde;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * Returns the edge if removed
     * or null otherwise.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     * @return The removed edge, or null if no edge removed.
     */
	
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
Road remvroad = null;
		
		for(Road rods:road) {
			if(rods.contains(sourceVertex) && rods.contains(destinationVertex) && rods.getWeight()==weight && rods.getName().equals(description))  {
			//	if(weight>-1&&description )
				//	if(rods.getWeight() == weight && rods.getDestination().getName().equals(description)) {
					
					road.remove(rods);
					return rods;
				}
			}
		return remvroad;
	}



	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	
	@Override
	public boolean removeVertex(Town v) {
		
//		 Town tow = null;
//		    for (Town t : town) {
//		        if (t.equals(v)) {
//		            tow = t;
//		            for (Road rd : road) {
//		                removeEdge(rd.getSource(), rd.getDestination(), rd.getWeight(), rd.getName());
//		            }
//		            town.remove(tow);
//		            return true;
//		        }
//		    }
//		    return false;
		return town.remove(v);

		}

	 /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	
	@Override
	public Set<Town> vertexSet() {
		return town;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
	    ArrayList<String> shortestPath = new ArrayList<String>();
	    
	    dijkstraShortestPath(sourceVertex);
	    
	    if (!prev.containsKey(destinationVertex)) {
	        return shortestPath; // Return empty ArrayList if there's no path
	    }
	    
	    while(!sourceVertex.equals(destinationVertex)) {
	        for(Road roadIterator : road) {
	            if (roadIterator.contains(destinationVertex) && roadIterator.contains(prev.get(destinationVertex))) {
	                shortestPath.add(0, prev.get(destinationVertex).getName() + " via " + roadIterator.getName() + " to "
	                        + destinationVertex.getName() + " " + roadIterator.getWeight() + " mi");
	            }
	        }
	        destinationVertex = prev.get(destinationVertex);
	    }
	    return shortestPath;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Set<Town> dijkstraShortestPath = new HashSet<>(town);

		for (Town tempTown : town) {
			distance.put(tempTown, Integer.MAX_VALUE);
		}
		distance.put(sourceVertex, 0); // Set the initial weight of sourceVertex to 0

		while (!dijkstraShortestPath.isEmpty()) {
			int min = Integer.MAX_VALUE;
			Town minVertex = null;

			for (Town tempTown : distance.keySet()) {
				if (min > distance.get(tempTown) && dijkstraShortestPath.contains(tempTown)) {
					min = distance.get(tempTown);
					minVertex = tempTown;
				}
			}

			// If no vertex found with minimum distance, exit the loop
			if (minVertex == null) {
				break;
			}

			sourceVertex = minVertex;

			for (Road rNode : road) {
				if (rNode.contains(sourceVertex)) {
					if (!rNode.getDestination().equals(sourceVertex)
							&& dijkstraShortestPath.contains(rNode.getDestination())) {
						if (distance.get(sourceVertex) + rNode.getWeight() < distance.get(rNode.getDestination())) {
							prev.put(rNode.getDestination(), sourceVertex);
							distance.put(rNode.getDestination(), rNode.getWeight() + distance.get(sourceVertex));
						}
					}
					if (!rNode.getSource().equals(sourceVertex) && dijkstraShortestPath.contains(rNode.getSource())) {
						if (distance.get(sourceVertex) + rNode.getWeight() < distance.get(rNode.getSource())) {
							prev.put(rNode.getSource(), sourceVertex);
							distance.put(rNode.getSource(), rNode.getWeight() + distance.get(sourceVertex));
						}
					}
				}
			}

			dijkstraShortestPath.remove(sourceVertex);
		}
	}
}