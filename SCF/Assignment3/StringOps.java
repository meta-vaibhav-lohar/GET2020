/*@author Vaibhav Lohar
 *@date 15-01-2020
 */
import java.util.Scanner;


	/**
 * The Class StringOps.
 */
public class StringOps {
	
	/** The scanner. */
	private static Scanner sc = new Scanner(System.in);

	
	/**
	 * Gets the string.
	 *
	 * @return the string
	 */
	public static String getString(){
		
		while (true) {
			try {
					return sc.nextLine();
				}
			catch (Exception ex) {
					System.out.println("Enter string value only :");
					sc.next();
				}
			}
	}
	
	/**
	 * Gets the int.
	 *
	 * @return the int
	 */
	public static Integer getInt(){
		
		while (true) {
			try {
					return sc.nextInt();
				}
			catch (Exception ex) {
					System.out.println("Enter Integer value only :");
					sc.next();
				}
			}
	}
	

	
	/**
	 * This method compares string are equal or not.
	 *
	 * @param str1 represents string 1 for comparing
	 * @param str2 represents string 1 for comparing
	 * @return 0 if not equal, else 1 if equal
	 */
	public static boolean compareEqual(String str1, String str2) {

		if(str1.length() != str2.length())
			return false ;
		else{
			int len = str1.length();
			int diff;
			for(int iterator =0; iterator < len; iterator++){
				diff=str1.charAt(iterator)-str2.charAt(iterator);
				if(diff != 0)
					return false ;
			}
		return true;
		}
		
	}
	
	/**
	 * Reverse string method.
	 *
	 * @param string represents string to be reversed
	 * @return reverseString is reversed string
	 */
	public static String reverse( String string){
		int len = string.length();
		String reverseString = "";
		for( int iterator = len -1 ; iterator >= 0; iterator--) {
			reverseString += string.charAt(iterator);
		}
		return reverseString;
		
	}
	
	/**
	 * This method flip the case of character in string.
	 *
	 * @param string represents string who's case will be flipped
	 * @return the flipped case string
	 */
	public static String caseFlipper(String string){
		int len = string.length();
		char flipped[] = string.toCharArray();
		for( int iterator = 0; iterator < len ; iterator++){
			if( flipped[iterator] >= 'a'  && flipped[iterator] <= 'z')
					flipped[iterator] = (char)((int)flipped[iterator] - 32);
			if( flipped[iterator] >= 'A'  && flipped[iterator] <= 'Z' )
					flipped[iterator] = (char)((int)flipped[iterator] + 32);				}
		
		String flippedStr = new String(flipped);
		return flippedStr;
	}
	
	/**
	 * This method returns the longest word in string.
	 *
	 * @param inputString represent the string to be searched for longest word
	 * @return the longest word
	 */
	public static String longestWordInString(String inputString){
		System.out.println(inputString.length());
		String editedString = inputString + " ";
		String word = "";
		int iterator=0;
		int startWord=0, endWord=0;
		int count =0;
		int maxLength=0;
		for(char ch: editedString.toCharArray() ){
			iterator++;
			if((ch >= 'a' && ch <= 'z') ||  ( ch >= 'A' && ch <= 'Z' ) ){
				count++;
			}else{
				
				if( maxLength <= count){
					
					maxLength = count;
					startWord = iterator - count;
					endWord = iterator;
					count=0;
				}
			}
		}

		for( iterator=startWord; iterator < endWord; iterator++){
			word += editedString.charAt(iterator);
		}
		return word;
	}
			
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main( String[] args){
		boolean flag = true;
		
		while(flag) {
			System.out.println("\n\nMenu :- \n"
					+ "1) Compare\n"
					+ "2) Reverse \n"
					+ "3) Case Flipper\n"
					+ "4) Largest word in the string\n"
					+ "5) Exit\n"
					+ "Enter your choice.... ");
			int choice = getInt();
			sc.nextLine();
			switch(choice){
		
				case 1: 
						
						System.out.println("Enter the String 1");
						String str1 = getString();
						
						System.out.println("Enter the String 2");
						String str2 = getString();
						boolean res = compareEqual(str1, str2);
						if( res)
							System.out.println("Equal");
						else
							System.out.println(" Not Equal");
						break;
						
				case 2: 
						
						System.out.println("Enter the String to reverse");
						String str3 = getString();
						String revStr=  reverse(str3);
						System.out.println("Reverse String :- "+ revStr);
						break;
				case 3:	
						System.out.println("Enter the String to flip case");
						String str4 = getString();
						String flippedStr= caseFlipper(str4);
						System.out.println("Reverse String :- "+ flippedStr);
						break;
						
				case 4:
						System.out.println("Enter the String to find largest word");
						String str5 = getString();
						String maxLengthWord= longestWordInString(str5);
						System.out.println("Largest Word :- "+ maxLengthWord);
						break;
					
				case 5: System.exit(0);
				default: 
						System.out.println("Invalid Option");
						break;
					
			}
		}
	}
}