package ques31;

public interface Queue {
	public boolean enQueue(String name,int priority);
	public void deQueue() throws Exception;
	public boolean isEmpty();
	public boolean isFull();
	public int getSize();
	public void display();

}