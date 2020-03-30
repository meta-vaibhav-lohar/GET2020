package ques1;


import java.util.List;

public interface Dictionary {
	
	 /**
     * This method adds node to a tree
     * @param key is the key
     * @param value is the value of the key
     * @return true if tree node is added successfully else false
     */
    public void addKeyValuePair(String key, String value);

    /**
     * This method deletes a node with a given key
     * @param key is the key to be deleted
     */
    public void deleteKeyValuePair(String key);

    /**
     * This method returns the value mapped to the given key
     * @param key whose value is to be search
     * @return {String} the value mapped to the given key
     */
    public String getValueAtKey(String key);

    /**
     * This method returns the sorted list of key value pair
     * @return {List<Data>}
     */
    public List<Data> sortedKeyValuePair();

    /**
     * This method returns the list of sorted nodes between the given two key values
     * @param key1 is smaller than key
     * @param key2 requires to greater than key
     * @return {List<Data>} list of sorted nodes between keys
     */
    public List<Data> sortBetweenTwoKeyValue(String key1, String key2);

}