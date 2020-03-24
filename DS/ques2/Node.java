package ques2;

public class Node {

	int data;
	Node next;
	private boolean isTraversed;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param data
	 */
	public Node(int data)
	{
		this.data = data;
		this.next = null;
		isTraversed = false;
	}

	public boolean getIsTraversed() {
		return isTraversed;
	}

	public void setTraversed(boolean isTraversed) {
		this.isTraversed = isTraversed;
	}
	
}
