package ques1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {

	public static void main(String[] args) throws org.json.simple.parser.ParseException {
	
		Scanner inputScanner = new Scanner(System.in);
		
        JSONParser parser = new JSONParser();
        List<Data> sortedAccordingToKeys = new ArrayList<>();
        JSONObject obj = null;
        BinarySearchTree bst = null;
        try {
            obj = (JSONObject) parser.parse(new FileReader("src\\ques1\\input.json"));
            bst = new BinarySearchTree(obj);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found ");
            e.printStackTrace();
        } catch (IOException e) {
        	System.out.println("File I/O Exception ");
            e.printStackTrace();
        }
        
        String choice;
        String key, key2;
        do
        {
        	System.out.println("\n1. Display the key value pairs in sorted order.");
        	System.out.println("2. Delete a key value pair.");
        	System.out.println("3. Find value at particular key.");
        	System.out.println("4. Get the sorted key value pair between two keys.");
        	System.out.println("5. Exit");
        	
        	System.out.print("\nEnter your choice : ");
        	choice = inputScanner.nextLine();
        	
        	switch(choice)
        	{
        	case "1" : 
        		System.out.println("\nThe key value pairs in sorted order are : ");
                bst.printTree(bst.root);
        		break;
        		
        	case "2" : 
        		System.out.print("\nEnter the key of the key value pair to be deleted : ");
        		key = inputScanner.nextLine();
        		bst.deleteKeyValuePair(key);
        		System.out.println("\nThe tree after deletion is : ");
        		bst.printTree(bst.root);
        		break;
        		
        	case "3" : 
        		System.out.print("\nEnter the key whose value to be determined : ");
        		key = inputScanner.nextLine();
        		System.out.println("\n\nThe value at key \"" + key + "\" is " + bst.getValueAtKey(key));
        		break;
        		
        	case "4" : 
        		System.out.print("\nEnter the key 1 : ");
        		key = inputScanner.nextLine();
        		System.out.print("Enter the key 2 : ");
        		key2 = inputScanner.nextLine();
        		System.out.println("\n\nThe sorted tree between key \"" + key + "\" and key \"" + key2 + "\" is : ");
                sortedAccordingToKeys = bst.sortBetweenTwoKeyValue(key, key2);
                for(int i = 0; i < sortedAccordingToKeys.size(); i++)
                {
                	System.out.println("\"" + sortedAccordingToKeys.get(i).getKey() + "\" : " + sortedAccordingToKeys.get(i).getValue());
                }
        		break;
        	case "5" : 
        		System.out.println("Thank you for using the system");
        		inputScanner.close();
        		break;
        	default : 
        	}
        	
        }while(!"5".equals(choice));
        
	}

}