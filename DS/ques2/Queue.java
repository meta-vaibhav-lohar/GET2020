package ques2;

/**
 * The Class Queue.
 */
public class Queue implements QueueInterface {
	
	/** The max size. */
	int MAX_SIZE = 5;
	
	/** The rear. */
	int front= -1, rear = -1;
	
	/** The queue. */
	int[] queue = new int[MAX_SIZE];

	/* (non-Javadoc)
	 * @see ques2.QueueInterface#enqueue(int)
	 */
	@Override
	public void enqueue(int element) {
		if (isFull()) {
			System.out.println("Queue is Full");

		}

		else if (front == -1) /* Insert First Element */
		{
			front = rear = 0;
			queue[rear] = element;
		}

		else if (rear == MAX_SIZE - 1 && front != 0) {
			rear = 0;
			queue[rear] = element;
		}

		else {
			rear++;
			queue[rear] = element;
		}
	}

	/* (non-Javadoc)
	 * @see ques2.QueueInterface#dequeue()
	 */
	@Override
	public void dequeue() {
		if( isEmpty()){
			System.out.println("Queue Empty");
		}
		if(isFull()){
			System.out.println("Queue Full");
		}
		if( front <= rear ){
			front++;
		}
		if( front > rear ){
			if( front == MAX_SIZE-1){
				front%=MAX_SIZE;
			}
			front++;
		}
	}

	/* (non-Javadoc)
	 * @see ques2.QueueInterface#isFull()
	 */
	@Override
	public boolean isFull() {
		if ((front == 0 && rear == MAX_SIZE - 1)
				|| (rear == (front - 1) % (MAX_SIZE - 1))) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see ques2.QueueInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if (front == -1) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see ques2.QueueInterface#displayQueue()
	 */
	@Override
	public void displayQueue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			System.out.println("\nQueue is Empty");
		}
		System.out.println("\nElements in Circular Queue are: ");
		if (rear >= front) {
			for (int index = front; index <= rear; index++)
				System.out.print(queue[index]+", ");
		} else {
			for (int index = front; index < MAX_SIZE; index++)
				System.out.print(queue[index]+", ");

			for (int index = 0; index <= rear; index++)
				System.out.print(queue[index]+", ");
		}
		System.out.println();
	}

}
