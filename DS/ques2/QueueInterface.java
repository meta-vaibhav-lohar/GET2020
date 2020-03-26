package ques2;

/**
 * The Interface QueueInterface.
 */
public interface QueueInterface {
	
	/**
	 * Enqueue.
	 *
	 * @param element the element
	 */
	void enqueue(int element);
	
	/**
	 * Dequeue.
	 */
	void dequeue();
	
	/**
	 * Display queue.
	 */
	void displayQueue();
	
	/**
	 * Checks if is full.
	 *
	 * @return true, if is full
	 */
	boolean isFull();
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	boolean isEmpty();
	
}
