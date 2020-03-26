package ques3;

/**
 * The Class Queue.
 */
public class Queue{
    
    /** The front. */
    int rear, front;
    
    /** The capacity. */
    int capacity;
    
    /** The queue. */
    String queue[];
    
    /** The fatch data count. */
    int fatchDataCount;

    /**
     * Instantiates a new queue.
     */
    Queue(){}
    
    /**
     * Instantiates a new queue.
     *
     * @param capacity the capacity
     */
    Queue(int capacity) {
        this.rear = -1;
        this.front = -1;
        this.capacity = capacity;
        this.queue = new String[this.capacity];
    }

    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return ((this.capacity - this.front + this.rear + 1) % (this.capacity));
    }

    /**
     * Checks if is full.
     *
     * @return true, if is full
     */
    public boolean isFull() {
        return ((this.rear + 1) % this.capacity == this.front);
    }

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return (this.front == -1);
    }

    /**
     * Adds the.
     *
     * @param value the value
     */
    public void add(String value) {
        if (isFull()) {
            System.out.println("Overflow");
        } else {
            this.rear = (this.rear + 1) % this.capacity;
            this.queue[this.rear] = value;
            if (this.front == -1) {
                this.front = this.rear;
            }
        }
    }

    /**
     * Delete.
     */
    public void delete() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            if (this.front == this.rear) {
                this.front = this.rear = -1;
            } else {
                this.front = (this.front + 1) % this.capacity;
            }
        }
    }

    /**
     * Show.
     */
    public void show() {
        int temporary1 = this.front;
        int i = 0, size;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            if (size() == 0) {
                size = 4;
            } else {
                size = size();
            }
            while (i < size) {
                System.out.print(this.queue[temporary1]+" ");
                temporary1 = (temporary1 + 1) % this.capacity;
                i++;
            }
        }
        System.out.println();
    }

    /**
     * Gets the queue.
     *
     * @return the queue
     */
    public String[] getQueue() {
        return queue;
    }
}
