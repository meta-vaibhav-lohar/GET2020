package ques2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class UniqueCharacters {

	private Map<String,Integer> cacheMap;
	
	/**
	 * Constructor to initialize the cacheMap
	 * @param cacheMap is the cache Map
	 */
	UniqueCharacters(Map<String, Integer> cacheMap) {
		this.cacheMap=new HashMap<String, Integer>();
		if(cacheMap != null){
			this.cacheMap = cacheMap;
		}
		
	}
	
	/**
	 * This method to counts the number of unique characters in a string
	 * @param inputString is the string to be checked
	 * @return {int} number of unique characters
	 */
	int countUniqueCharacters(String inputString){
		
		Set<Character> uniqueCharSet=new HashSet<Character>();
		
		if(inputString==null || inputString.equals(" ")){
			
			System.out.println("Input string is Invalid");
		}
		else{
			
			if(cacheMap !=null && cacheMap.containsKey(inputString)){
				return cacheMap.get(inputString);
			}
			else{
				
				inputString=inputString.toLowerCase();
				
				for(int i=0;i<inputString.length();++i){
					
					char charAtIndex=inputString.charAt(i);
					
					if(charAtIndex==' '){
						continue;
					}
					else{
						if(!uniqueCharSet.contains(charAtIndex)){
							uniqueCharSet.add(charAtIndex);
						}
					}
				}
			}
		}
		cacheMap.put(inputString, uniqueCharSet.size());
		return uniqueCharSet.size();
	}
	
}