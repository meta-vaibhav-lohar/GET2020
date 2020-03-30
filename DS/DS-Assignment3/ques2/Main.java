package ques2;

public class Main {

	public static void main(String[] args) {
		
		PriorityQueueImplementation priorityQueue = new PriorityQueueImplementation(10);
		priorityQueue.enqueue(new Job("Job 1", 21));
		priorityQueue.enqueue(new Job("Job 2", 30));
		priorityQueue.enqueue(new Job("Job 3", 20));
		priorityQueue.enqueue(new Job("Job 4", 10));
		priorityQueue.enqueue(new Job("Job 5", 9));
		priorityQueue.enqueue(new Job("Job 6", 52));
		priorityQueue.enqueue(new Job("Job 7", 14));
		priorityQueue.enqueue(new Job("Job 8", 3));
		priorityQueue.enqueue(new Job("Job 9", 8));
		priorityQueue.enqueue(new Job("Job 10", 1));
		
		System.out.println("The priority queue is : ");
		priorityQueue.printQueue();
		
		System.out.println("\nThe maximum priority job is : " + priorityQueue.peek().getJobName());
		
		System.out.println("\nThe priority queue after polling is : ");
		priorityQueue.poll();
		priorityQueue.printQueue();
		
		System.out.println("\nThe priority queue after some deletions is : ");
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		priorityQueue.dequeue();
		
		priorityQueue.printQueue();

	}

}