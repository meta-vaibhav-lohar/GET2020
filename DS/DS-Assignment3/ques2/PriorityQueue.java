package ques2;

public interface PriorityQueue {

	/**
	 * This method inserts an value to the queue
	 * @param value to be added to the queue
	 * @return {boolean} true if value is added else false
	 */
	public void enqueue(Job job) ;

	/**
	 * This method removes a value from the queue
	 * @return {Job} removed value
	 */
	public Job dequeue();

	/**
	 * This method checks whether the queue is empty or not
	 * @return {boolean}
	 */
	public boolean isEmpty() ;

	/**
	 * This method checks whether the queue is full or not
	 * @return {boolean}
	 */
	public boolean isFull() ;
	
	/**
	 * This method polls an element from the queue
	 * Polls means extracting the maximum priority element from the queue
	 * @return {Job} maximum priority job
	 */
	public Job poll();
	
	/**
	 * This method peeks an element from the queue
	 * Polls means displays the maximum priority element from the queue
	 * @return {Job} maximum priority job
	 */
	public Job peek();
}