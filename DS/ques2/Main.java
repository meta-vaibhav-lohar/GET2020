package ques2;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.enqueue(1);
		q.displayQueue();
		q.enqueue(2);
		q.displayQueue();
		q.enqueue(3);
		q.displayQueue();
		q.enqueue(4);
		q.displayQueue();
		q.enqueue(5);
		q.displayQueue();
		q.enqueue(6);
		q.displayQueue();
		q.dequeue();
		q.displayQueue();
		q.enqueue(1);
		q.displayQueue();
	}

}
