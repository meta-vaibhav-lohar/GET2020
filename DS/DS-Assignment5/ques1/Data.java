package ques1;

public class Data {
	
	String key;
	String value;
	
	/**
	 * Constructor to initialize a key value pair in the dictionary
	 * @param key is the key
	 * @param value is the value corresponding to the key
	 */
	Data(String key, String value)
	{
		this.key = key;
		this.value = value;
	}

	/**
	 * This method returns the key
	 * @return {String}
	 */
	public String getKey() {
		return key;
	}

	/**
	 * This method returns the value
	 * @return
	 */
	public String getValue() {
		return value;
	}

}