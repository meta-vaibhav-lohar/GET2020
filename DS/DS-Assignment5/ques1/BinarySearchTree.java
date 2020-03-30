package ques1;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class BinarySearchTree implements Dictionary {
	
	 Node root;
	
	/**
	 * Constructor to add data from the JSON File
	 * @param object is the whole JSON object
	 */
	public BinarySearchTree(JSONObject object) {
		this.root = null;
       for (Object key : object.keySet()) {
       	addKeyValuePair(String.valueOf(key).toLowerCase(), (String)object.get(key));
       }
	}

	/**
   * This method adds node to a tree by calling another method which inserts the node recursively in the tree
   * @param key is the key
   * @param value is the value of the key
   * @return true if tree node is added successfully else false
   */
	@Override
	public void addKeyValuePair(String key, String value) {
		
		// if key is empty
       if (key == null || key.equals(" ") || value == null || value.equals(" ")) {
           System.out.println("Key cannot be Empty");
           return;
       }
       // create new Node to be inserted
       Node newNode = new Node(new Data(key, value));
       // call recursive function traverse from root to correct Position to add newNode
       this.root = insertRecursively(this.root, newNode);
       return;
		
	}

	/**
	* This is the helper method which is used to insert the nodes in the binary search tree recursively
	* @param currentNode is the node where the new node is to be inserted
	* @param newNode is the node to be inserted
	* @return {Node}
	*/
	Node insertRecursively(Node currentNode, Node newNode) {
		 //If the tree is empty then the newNode is the root of the node
		 if(currentNode == null)
		 {
			 currentNode = newNode;
			 return currentNode;
		 }
		 //Else insert the nodes recursively
		 if(currentNode.getKeyValuePair().getKey().compareToIgnoreCase(newNode.getKeyValuePair().getKey()) > 0)
		 {
			 currentNode.leftChild = insertRecursively(currentNode.leftChild, newNode);
		 }
		 else
		 {
			 currentNode.rightChild = insertRecursively(currentNode.rightChild, newNode);
		 }
		
		 return currentNode;
	}

	/**
   * This method deletes a node with a given key
   * @param key is the key to be deleted
   */
	@Override
	public void deleteKeyValuePair(String key) {
		// if key is empty
       if (key == null || key.equals(" ")) {
          System.out.println("Invalid Key");
          return;
       }
       this.root = deleteRecursively(root, key);
       return;
	}

	/**
	* This is the helper method which is used to delete nodes in the binary search tree recursively
	* @param currentNode is the node which is to be checked for deletion
	* @param key is the key which is to be deleted
	* @return {Node}
	*/
	Node deleteRecursively(Node currentNode, String key) {
		//if tree is empty
		if(currentNode == null)
		{
			return currentNode;
		}
		//else recur the tree to find the key
		if(currentNode.getKeyValuePair().getKey().compareToIgnoreCase(key) > 0)
		{
			currentNode.leftChild = deleteRecursively(currentNode.leftChild, key);
		}
		else if(currentNode.getKeyValuePair().getKey().compareToIgnoreCase(key) < 0)
		{
			currentNode.rightChild = deleteRecursively(currentNode.rightChild, key);
		}
		//If the key is found then delete the current node
		else
		{
			// node with only one child or no child
           if (currentNode.leftChild == null)
               return currentNode.rightChild;
           else if (currentNode.rightChild == null)
               return currentNode.leftChild;

           //Else find the minimum in the right sub tree and replace the current node with it and delete that
           Data data = minValue(currentNode.rightChild);
           currentNode.setKeyValuePair(data);
           
           currentNode.rightChild = deleteRecursively(currentNode.rightChild, currentNode.getKeyValuePair().getKey());
		}
		return currentNode;
	}
	
	/**
	* Helper method to find the minimum key in the sub tree
	* @param currentNode is the root of the sub-tree
	* @return {Node} the minimum key
	*/
	Data minValue(Node currentNode) {
       Data minKey = currentNode.getKeyValuePair();
       while (currentNode.leftChild != null) {
           minKey = currentNode.leftChild.getKeyValuePair();
           currentNode = currentNode.leftChild;
       }
       return minKey;
   }

	/**
   * This method returns the value mapped to the given key
   * @param key whose value is to be search
   * @return {String} the value mapped to the given key
   */
	@Override
	public String getValueAtKey(String key) {
		Node currentNode = this.root;
		while(currentNode != null)
		{
			if(currentNode.getKeyValuePair().getKey().equalsIgnoreCase(key))
			{
				return currentNode.getKeyValuePair().getValue();
			}
			if(currentNode.getKeyValuePair().getKey().compareToIgnoreCase(key) > 0)
			{
				currentNode = currentNode.leftChild;
			}
			else
			{
				currentNode = currentNode.rightChild;
			}
		}
		return null;
	}

	/**
   * This method returns the sorted list of key value pair
   * @return {List<Data>}
   */
	@Override
	public List<Data> sortedKeyValuePair() {
		List<Data> sortedDictionary = new ArrayList<>();
		inorderRecursively(root, sortedDictionary);
		return sortedDictionary;
	}

	/**
	* This is the helper method which is used to sort the nodes in the binary search tree recursively
	* @param currentNode is the current node of the tree
	* @param sortedDictionary is the list where the sorted dictionary is stored
	*/
	void inorderRecursively(Node currentNode, List<Data> sortedDictionary) { 
       if (currentNode != null) { 
           inorderRecursively(currentNode.leftChild, sortedDictionary); 
           sortedDictionary.add(currentNode.getKeyValuePair());
           inorderRecursively(currentNode.rightChild, sortedDictionary); 
       } 
   } 
	
	 /**
   * This method returns the list of sorted nodes between the given two key values
   * @param key1 is smaller than key
   * @param key2 requires to greater than key
   * @return {List<Data>} list of sorted nodes between keys
   */
	@Override
	public List<Data> sortBetweenTwoKeyValue(String key1, String key2) {
		List<Data> sortedKeyValuePair = new ArrayList<>();
		sortedKeyValuePair = sortedKeyValuePair();
		List<Data> sortedAccordingToKeys = new ArrayList<>();
		int index1 = 0, index2 = 0;
		for(int i = 0; i < sortedKeyValuePair.size(); i++)
		{
			if(sortedKeyValuePair.get(i).getKey().equalsIgnoreCase(key1))
			{
				index1 = i;
			}
			if(sortedKeyValuePair.get(i).getKey().equalsIgnoreCase(key2))
			{
				index2 = i;
			}
		}
		
		for(int i = index1; i <= index2; i++)
		{
			sortedAccordingToKeys.add(sortedKeyValuePair.get(i));
		}
		
		return sortedAccordingToKeys;
	}

	/**
	* This method(Recursive) prints the tree in inOrder traversal.
	* @param root is the root of the tree
	*/
	void printTree(Node root) { 
       if (root != null) { 
       	printTree(root.leftChild); 
           System.out.println("\"" + root.keyValuePair.getKey() + "\"" + " : " + root.getKeyValuePair().getValue()); 
           printTree(root.rightChild); 
       } 
   } 
}