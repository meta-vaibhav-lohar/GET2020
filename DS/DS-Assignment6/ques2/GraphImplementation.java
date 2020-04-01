package ques2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class GraphImplementation implements Graph {

	 private int noOfVertices;
	    private LinkedList<Vertex> adjacentList[];

	    /**
	     * Constructor to initialize the data members of the class
	     * @param noOfVertices is the number of vertices of the graph
	     */
	    public GraphImplementation(int noOfVertices) {
	        if (noOfVertices <= 0) {
	            System.out.println("Invalid no of vertices:No. Of vertices can't be negative or 0");
	        }
	        this.noOfVertices = noOfVertices;
	        adjacentList = new LinkedList[noOfVertices];
	        for (int i = 0; i < noOfVertices; ++i)
	            adjacentList[i] = new LinkedList<Vertex>();
	    }

	    /** 
	     * This method adds new edge in Graph
	     * @param source is the source vertex
	     * @param destination is the destination vertex
	     * @param weight is the weight of that Edge
	     */
	    public boolean addEdge(int source, int destination, int weight) {
	        if (source < 0 || source >= noOfVertices || destination < 0
	                || destination >= noOfVertices || weight < 0) {
	            System.out.println("Invalid parameters");
	            return false;
	        }
	        else
	        {
	        	// node to add link from source to destination
		        Vertex nodeSource = new Vertex(destination, weight);
		        adjacentList[source].add(nodeSource);
		        // node to add link from destination to source
		        Vertex nodeDest = new Vertex(source, weight);
		        adjacentList[destination].add(nodeDest);
		        return true;
	        }
	    }

	    /**
		 * This method is used to find if a graph is connected i.e., all nodes are reachable, or not
		 * @return {boolean}
		 */
	    @Override
	    public boolean isConnected() {
	        // if vertex is connected index is true
	        boolean[] visited = new boolean[noOfVertices];
	        recursivelyCallConnected(0, visited);
	        for (boolean visit : visited) {
	            if (!visit) {
	                return false;
	            }
	        }
	        return true;
	    }

	    /**
	     * Utility method to check connected vertices
	     * @param index whose connected vertices to be checked
	     * @param visited boolean Array to have record of checked vertices
	     */
	    private void recursivelyCallConnected(int index, boolean[] visited) {
	        visited[index] = true;
	        for (Vertex neighbour : adjacentList[index]) {
	            if (!visited[neighbour.getVertex()])
	                recursivelyCallConnected(neighbour.getVertex(), visited);
	        }

	    }

	    /**
		 * This method is used to find list of all nodes that are reachable from the given source node
		 * @param source is the node from which the reachable vertices is to be found
		 * @return {List<Integers>} The list of all reachable node
		 */
	    @Override
	    public List<Integer> getReachableVertices(int source) {
	        List<Integer> reachableNodes = new ArrayList<Integer>();
	        boolean[] visited = new boolean[noOfVertices];
	        if (source < 0 || source >= noOfVertices)
	            System.out.println("Enter valid start Index");
	        recursivelyCallConnected(source, visited);
	        for (int i = 0; i < noOfVertices; ++i)
	            if (visited[i] == true)
	                reachableNodes.add(i);
	        return reachableNodes;
	    }

	    /**
		 * This method is used to find minimum spanning tree of a graph
		 * @return {int[]} the integer array of the node's vertices such that the total sum of the edges in minimum
		 */
	    @Override
	    public int[] getMST() {
	        // Whether a vertex is in PriorityQueue or not
	        Boolean[] visited = new Boolean[this.noOfVertices];
	        Vertex[] nodeList = new Vertex[this.noOfVertices];
	        // Stores the parents of a vertex
	        int[] parent = new int[this.noOfVertices];
	        // PriorityQueue
	        PriorityQueue<Vertex> queue = new PriorityQueue<>(this.noOfVertices,
	                new ComparatorOverride());

	        for (int i = 0; i < this.noOfVertices; i++) {
	            // Initialise to false
	            visited[i] = false;
	            // Initialise nodeList values to infinity
	            nodeList[i] = new Vertex();
	            nodeList[i].setWeight(Integer.MAX_VALUE);
	            nodeList[i].setVertexName(i);
	            parent[i] = -1;
	        }
	        // Set key value to 0 so that it is extracted first out of PriorityQueue
	        nodeList[0].setWeight(0);

	        for (int i = 0; i < this.noOfVertices; i++)
	            queue.add(nodeList[i]);

	        // Loops until the PriorityQueue is not empty
	        while (!queue.isEmpty()) {
	            // Extracts a node with min weight value
	            Vertex node0 = queue.poll();
	            // Include that node into mstset
	            visited[node0.getVertex()] = true;

	            // For all adjacent vertex of the extracted vertex V
	            for (Vertex node : this.adjacentList[node0.getVertex()]) {
	                // If Vertex is in PriorityQueue
	                if (visited[node.getVertex()] == false) {
	                    // If the key value of the adjacent vertex is more than the
	                    // extracted key
	                    // update the key value of adjacent vertex to update first
	                    // remove and add the updated vertex
	                    if (nodeList[node.getVertex()].getWeight() > node
	                            .getWeight()) {
	                        queue.remove(nodeList[node.getVertex()]);
	                        nodeList[node.getVertex()].setWeight(node.getWeight());
	                        queue.add(nodeList[node.getVertex()]);
	                        parent[node.getVertex()] = node0.getVertex();
	                    }
	                }
	            }
	        }
	        return parent;
	    }

	    /**
		 * This method is used to find the shortest path between the source and the destination
		 * @param source is the source node
		 * @param destination is the destination node
		 * @return {int} The minimum distance between source node and destination node
		 */
	    @Override
	    public int getShortestPath(int source, int destination) {
	        if (source < 0 || source >= this.noOfVertices || destination < 0 || destination >= this.noOfVertices)
	            System.out.println("Invalid parameters");

	        // distance[i] will hold the shortest distance from source to i
	        int distance[] = new int[this.noOfVertices];
	        // shortestPath[i] will true if vertex i is included in shortest path
	        boolean shortestPath[] = new boolean[this.noOfVertices];

	        // Initialize all distances as INFINITE
	        for (int i = 0; i < this.noOfVertices; i++) {
	            distance[i] = Integer.MAX_VALUE;
	        }

	        // Distance of source vertex from itself is always 0
	        distance[source] = 0;

	        // Find shortest path for all vertices
	        for (int count = 0; count < this.noOfVertices - 1; count++) {
	            // Pick the minimum distance vertex from the set of vertices not yet processed.
	            // minDistanceVertex is always equal to source in first iteration.
	            int minDistanceVertex = getMinKeyVertex(distance, shortestPath);

	            // Mark the picked vertex as processed
	            shortestPath[minDistanceVertex] = true;

	            // Update distance value of the adjacent vertices of the picked vertex.
	            for (Vertex edge : adjacentList[minDistanceVertex]) {
	                int vertex = edge.getVertex();
	                // Update distance[v] only if is not in shortestPath, there is an edge from u to v, and
	                // total weight of path from src to v through u is smaller than current value of distance[v]
	                if (!shortestPath[vertex]
	                        && distance[minDistanceVertex] != Integer.MAX_VALUE
	                        && distance[minDistanceVertex] + edge.getWeight() < distance[vertex]) {
	                    distance[vertex] = distance[minDistanceVertex]
	                            + edge.getWeight();
	                }
	            }
	        }
	        return distance[destination];
	    }

	    /**
	     * Utility method to find the index of the node with minimum edge weight and which is unvisited
	     * @param distance is the distance array
	     * @param mstSet is the is the set which contains the node of the MST
	     * @return {int} index of the node with minimum edge weight
	     */
	    private int getMinKeyVertex(int distance[], boolean mstSet[]) {
	        // Initialize min value
	        int min = Integer.MAX_VALUE;
	        int minIndex = -1;

	        for (int i = 0; i < this.noOfVertices; i++)
	            if (mstSet[i] == false && distance[i] < min) {
	                min = distance[i];
	                minIndex = i;
	            }
	        return minIndex;
	    }

	    /**
	     * This method is used to print the graph
	     */
	    public void printTree() {
	        for (int v = 0; v < this.noOfVertices; v++) {
	            System.out.print("Adjacency list of vertex " + v + ": ");
	            System.out.print("head");
	            for (Vertex node : this.adjacentList[v]) {
	                System.out.print(" -> " + node.getVertex());
	            }
	            System.out.println();
	        }
	    }


}