package ques1;

public class Node {
	
	 Data keyValuePair;
	 Node leftChild;
	 Node rightChild;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param keyValuePair is the key-value pair
	 */
	public Node(Data keyValuePair) {
		this.keyValuePair = keyValuePair;
		this.leftChild = null;
		this.rightChild = null;
	}

	/**
	 * This method returns the key-value pair
	 * @return {Data}
	 */
	public Data getKeyValuePair() {
		return keyValuePair;
	}

	/**
	 * This method returns the left child of the node
	 * @return {Node}
	 */
	public Node getLeftChild() {
		return leftChild;
	}

	/**
	 * This method returns the right child of the node
	 * @return {Node}
	 */
	public Node getRightChild() {
		return rightChild;
	}

	public void setKeyValuePair(Data keyValuePair) {
		this.keyValuePair = keyValuePair;
	}
}