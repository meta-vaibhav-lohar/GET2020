package ques1;

import java.util.ArrayList;
import java.util.Set;

/**
 * The Class DirectoryTree.
 */
public class DirectoryTree {
	
	/** The root dir. */
	Node rootDir ;
	
	/** The current dir. */
	Node currentDir;
	
	/** The path string. */
	static String pathString;
	
	/**
	 * Instantiates a new directory tree.
	 */
	DirectoryTree(){	
		rootDir = new Node("/");
		currentDir = rootDir;
	}
	
	/**
	 * Gets the current dir.
	 *
	 * @return the current dir
	 */
	String getCurrentDir(){
		return currentDir.dirName;
	}
	
	/**
	 * Mkdir.
	 *
	 * @param dirName the dir name
	 */
	void mkdir(String dirName){
		Node newDir = new Node(dirName);		
		currentDir.subDir.put(dirName, newDir);
		newDir.parentDir = currentDir;
	}
	
	/**
	 * Bk.
	 *
	 * @return true, if successful
	 */
	boolean bk(){
		if(currentDir.parentDir == null){
			System.out.println("No Parent Directory For Root");
			return false;
		}else{
		currentDir = currentDir.parentDir;
		}
		return true;
	}
	
	/**
	 * Cd.
	 *
	 * @param changeDir the change dir
	 */
	void cd(String changeDir){
		String[] dirArray=changeDir.split("/");
		for(int i=0;i<dirArray.length;i++){
			if(dirArray[i].equals("..")){
				if(!bk()){
					System.out.println("No Directory");
				}
			}
			else{
				Set<String> dirList =  currentDir.subDir.keySet();
				if(dirList.contains(dirArray[i])){
				currentDir = currentDir.subDir.get(dirArray[i]);
				}else{
					System.out.println("Directory do not exist");
				}
			}
		}
		
	}
	
	/**
	 * Ls.
	 */
	void ls(){
		Set<String> dirNameSet = currentDir.subDir.keySet();
		for(String dirName: dirNameSet){
			System.out.println(dirName + "\t\t" + currentDir.subDir.get(dirName).creationDate );
		}
	}
	
	/**
	 * Tree.
	 *
	 * @param traverser the traverser
	 */
	void tree(Node traverser){
		if(traverser.subDir.size()!=0){

			System.out.println(traverser.dirName + "\t "+ traverser.creationDate);
			Set<String> dirNameSet = traverser.subDir.keySet();
			for(String dirName: dirNameSet){

				tree(traverser.subDir.get(dirName));
			}
		}
		else{
			System.out.println(traverser.dirName + "\t "+ traverser.creationDate);
		}
	}
	
	/**
	 * Find.
	 *
	 * @param dirName the dir name
	 * @param finder the finder
	 */
	void find(String dirName, Node finder ){
		if(finder.subDir.size()!=0){
			if(finder.dirName.contains(dirName)){ pathString+="/"+finder.dirName; System.out.println(finder.dirName);}

			Set<String> dirNameSet = finder.subDir.keySet();
			for(String dir: dirNameSet){
				find(dirName,finder.subDir.get(dir));
			}
		}
		else{
			if(finder.dirName.contains(dirName)){ pathString+="/"+finder.dirName; System.out.println(finder.dirName);}
		}
		if(finder.dirName.equals("/")){
			pathString="";
		}else{
			pathString="/"+finder.dirName;
		}
	}
		
}