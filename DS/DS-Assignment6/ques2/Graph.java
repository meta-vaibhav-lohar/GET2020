package ques2;

import java.util.List;

public interface Graph {

	/**
	 * This method is used to find if a graph is connected i.e., all nodes are reachable, or
	 * not
	 * 
	 * @return {boolean}
	 */
	public boolean isConnected();

	/**
	 * This method is used to find list of all nodes that are reachable from the given source
	 * node
	 * 
	 * @param source is the node from which the reachable vertices is to be found
	 * @return {List<Integers>} The list of all reachable node
	 */
	public List<Integer> getReachableVertices(int source);

	/**
	 * This method is used to find minimum spanning tree of a graph
	 * 
	 * @return {int[]} the integer array of the node's vertices such that the total sum of the
	 *         edges in minimum
	 */
	public int[] getMST();

	/**
	 * This method is used to find the shortest path between the source and the destination
	 * 
	 * @param source is the source node
	 * @param destination is the destination node
	 * @return {int} The minimum distance between source node and destination node
	 */
	public int getShortestPath(int source, int destination);

}