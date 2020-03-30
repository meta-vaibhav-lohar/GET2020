package ques31;
public class PriorityBowler implements Queue {
	public BowlersDetails[] queue;
	private int noOfBowlers = 0;
	private int Size;
	private int noOfViratBalls;

	/**
	 * @param noOfbowler
	 * @param ViratBalls
	 * Constructor to set the values
	 */
	public PriorityBowler(int noOfbowler, int ViratBalls) {
		try {
			this.Size = noOfbowler + 1;
			this.queue = new BowlersDetails[Size];
			this.noOfViratBalls = ViratBalls;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * enQueue method will dequeue names in the last
	 * return true if successfully inserted
	 */
	public boolean enQueue(String name, int Balls) {
		try {
			if(name==null)
			{
				throw (new Exception("name can't be null"));
			}
			if (!isFull()) {
				BowlersDetails object = new BowlersDetails(name, Balls);
				queue[++noOfBowlers] = object;
				int position = noOfBowlers;
				while ((position != 1) && object.getPriority() > queue[position / 2].getPriority()) {
					queue[position] = queue[position / 2];
					position = position / 2;
				}
				queue[position] = object;
			} else {
				throw new IndexOutOfBoundsException("Queue Array is full");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * deQueue method will dequeue names from the last one by one
	 */
	public void deQueue() {
		try {
			while (noOfViratBalls != 0) {
				if (isEmpty()) {
					throw (new Exception("queue is empty"));
				}
				BowlersDetails store = queue[1];
				queue[1] = queue[noOfBowlers];
				int count = noOfBowlers - 1;

				while (count != 0) {
					int pos = count;
					while ((pos != 1) && queue[pos].getPriority() > queue[pos / 2].getPriority()) {
						BowlersDetails temp = queue[pos];
						queue[pos] = queue[pos / 2];
						queue[pos / 2] = temp;
						pos = pos / 2;
					}
					
					count--;
				}
				noOfBowlers--;
				noOfViratBalls--;
				enQueue(store.getName(), store.getPriority() - 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean isEmpty() {
		if (noOfBowlers == 0)
			return true;
		return false;
	}

	/**
	 * isFull method will check if the priority queue is full
	 */
	@Override
	public boolean isFull() {
		if (noOfBowlers == Size)
			return true;
		return false;
	}

	/**
	 * return the total no. of bowlers 
	 */
	@Override
	public int getSize() {
		return noOfBowlers;
	}

	/**
	 * display method will display the result
	 */
	@Override
	public void display() {
		try {
			for (int i = 1; i <= noOfBowlers; i++) {
				System.out.println("BowlerDetail is : " + queue[i].getName() +" " + queue[i].getPriority());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}