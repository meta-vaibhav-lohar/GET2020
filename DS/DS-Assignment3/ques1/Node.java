package ques1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * The Class Node.
 */
public class Node {
	
	/** The dir name. */
	String dirName;
	
	/** The creation date. */
	Date creationDate;
	
	/** The parent dir. */
	Node parentDir;
	
	/** The sub dir. */
	HashMap<String, Node> subDir;

	/**
	 * Instantiates a new node.
	 *
	 * @param dirName the dir name
	 */
	Node(String dirName){
		this.dirName = dirName;
		this.creationDate = new Date();
		if(dirName == "/"){
			this.parentDir=null;
		}
		this.subDir = new HashMap<String, Node>();
	}

}

 