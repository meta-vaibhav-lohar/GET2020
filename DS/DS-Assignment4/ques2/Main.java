package ques2;

public class Main {

	public static void main(String[] args) {
		
		UniqueCharacters count = new UniqueCharacters(null);
		System.out.println("Unique Characters in the given string are : " + count.countUniqueCharacters("abcde@2019"));
		System.out.println("Unique Characters in the given string are : " + count.countUniqueCharacters("abcde"));
		System.out.println("Unique Characters in the given string are : " + count.countUniqueCharacters("abbcddee"));
	}

}