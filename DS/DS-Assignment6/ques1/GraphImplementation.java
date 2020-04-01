package ques1;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GraphImplementation implements Graph {

	private int[][] graph;
	private int noOfVertices;

	/**
	 * Constructor to initialize the data members of the class 
	 * @param noOfVertices is the number of vertices of a graph
	 */
	GraphImplementation(int noOfVertices) {
		if(noOfVertices <= 0)
		{
			System.out.println("Enter Some amount of vertices.");
		}
		else
		{
			this.noOfVertices = noOfVertices;
			graph = new int[this.noOfVertices][this.noOfVertices];
		}
	}
	
	/**
	 * This method adds an edge to the graph
	 * @param source is the source vertex
	 * @param destination is the destination vertex
	 * @param weight is the weight of the edge
	 * @return {boolean}
	 */
	boolean addEdgeToTheGraph(int source, int destination, int weight)
	{
		if (source < 0 || source >= noOfVertices || destination < 0
                || destination >= noOfVertices || weight < 0) {
            System.out.println("Invalid parameters");
            return false;
        }
		else
		{
			graph[source][destination] = weight;
			graph[destination][source] = weight;
			return true;
		}
	}

	/**
	 * This method is used to find if a graph is connected i.e., all nodes are reachable, or not
	 * @return {boolean}
	 */
	@Override
	public boolean isConnected() {
		Stack<Integer> stackOfVertices = new Stack<Integer>();
		Set<Integer> traversedElements = new HashSet<Integer>();
		stackOfVertices.push(0);
		while (!stackOfVertices.isEmpty()) {
			int deletedElement = stackOfVertices.pop();
			traversedElements.add(deletedElement);
			for (int j = 0; j < graph[0].length; j++) {
				if (traversedElements.contains(j)) {
					continue;
				} else if (graph[deletedElement][j] > 0) {
					stackOfVertices.push(j);
				}
			}
		}
		return (traversedElements.size() == graph.length);
	}

	/**
	 * This method is used to find list of all nodes that are reachable from the given source node
	 * @param source is the node from which the reachable vertices is to be found
	 * @return {List<Integers>} The list of all reachable node
	 */
	@Override
	public List<Integer> getReachableVertices(int source) {
		if (source < 0 || source >= noOfVertices)
		{
			System.out.println("Enter valid start Index");
			return null;
		}
		List<Integer> reachableVertices = new ArrayList<Integer>();
		reachableVertices.add(source);
		for (int j = 0; j < graph[0].length; j++) {
			if (graph[source][j] > 0) {
				reachableVertices.add(j);
			}
		}
		return reachableVertices;
	}

	/**
	 * This method is used to find minimum spanning tree of a graph
	 * @return {int[][]} the integer array of the node's vertices such that the total sum of the edges in minimum
	 */
	@Override
	public int[][] getMST() 
	{
		List<Integer> treeNodes = new LinkedList<Integer>();
		int minimumWeightedTree[][] = new int[this.noOfVertices][this.noOfVertices];
		minimumWeightedTree[0][0] = 0;
		treeNodes.add(0);
		int minWeight = Integer.MAX_VALUE;
		int startVertex = 0;
		int endVertex = 0;
		int sizeOfTree = treeNodes.size();

		// i and k is used to iterate over treeNodes that contains the nodes in Minimum
		// Spanning Tree, For every i in treeNodes, we are checking the weight of i to j
		// vertex
		for (int i = treeNodes.get(0), k = 0; sizeOfTree != this.noOfVertices;) {
			for (int j = 0; j < this.noOfVertices; j++) {
				if (graph[i][j] != 0 && !treeNodes.contains(j) && graph[i][j] < minWeight) {
					endVertex = j;
					startVertex = i;
					minWeight = graph[i][j];
				}
			}
			if (k < sizeOfTree - 1) {
				k++;
				i = treeNodes.get(k);
			} else if (k == sizeOfTree - 1) {
				treeNodes.add(endVertex);
				sizeOfTree = treeNodes.size();
				minimumWeightedTree[startVertex][endVertex] = minWeight;
				minimumWeightedTree[endVertex][startVertex] = minWeight;
				k = 0;
				i = treeNodes.get(k);
				minWeight = Integer.MAX_VALUE;
			}
		}
		return minimumWeightedTree;
	}

	/**
	 * This method is used to find the shortest path between the source and the destination
	 * @param source is the source node
	 * @param destination is the destination node
	 * @return {int} The minimum distance between source node and destination node
	 */
	@Override
	public int getShortestPath(int source, int destination) 
	{
		  if (source < 0 || source >= this.noOfVertices || destination < 0 || destination >= this.noOfVertices)
		  {
			  System.out.println("Invalid parameters");
			  return -1;
		  }
		  
		int distanceOfVertices[] = new int[graph.length];
		boolean vertexVisit[] = new boolean[graph.length];
		for (int i = 0; i < graph.length; i++) {
			distanceOfVertices[i] = Integer.MAX_VALUE;
			vertexVisit[i] = false;
		}
		distanceOfVertices[source] = 0;

		// Find Shortest path for all vertices
		for (int i = 0; i < graph.length - 1; i++) {
			int u = minDistance(distanceOfVertices, vertexVisit);

			// Mark the Selected vertex as visited
			vertexVisit[u] = true;

			// Updating Distance of the adjacent vertices of the selected vertex.
			for (int v = 0; v < graph.length; v++) {
				if (!vertexVisit[v] && graph[u][v] != 0 && distanceOfVertices[u] != Integer.MAX_VALUE
						&& distanceOfVertices[u] + graph[u][v] < distanceOfVertices[v]) {
					distanceOfVertices[v] = distanceOfVertices[u] + graph[u][v];
				}
			}
		}
		return distanceOfVertices[destination];
	}

	/**
	 * Utility method that picks the Minimum Distance Vertex from the set of vertices not yet visited.
	 * @param distanceOfVertices is the distance matrix
	 * @param vertexVisit is the boolean array which maintains the record of visited vertices
	 * @return {int} the minimum distance
	 */
	int minDistance(int distanceOfVertices[], boolean vertexVisit[]) {
		int minimumDistance = Integer.MAX_VALUE;
		int index = -1;
		for (int v = 0; v < graph.length; v++)
			if (vertexVisit[v] == false && distanceOfVertices[v] <= minimumDistance) {
				minimumDistance = distanceOfVertices[v];
				index = v;
			}
		return index;
	}

	/**
	 * This method prints the graph
	 */
	public void printTree() {
		int i,j,k = 0;
		for(i = 0; i < this.noOfVertices; i++)
		{
			for(j = 0; j < this.noOfVertices; j++)
			{
				if(graph[i][j] > 0)
				{
					System.out.println("Edge : " + (k++));
					System.out.println("\tSource Node : " + i + " Destination Node : " + j + " Weight : " + graph[i][j]);
				}
			}
		}
	}

}