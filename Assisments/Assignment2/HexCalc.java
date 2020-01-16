import java.util.Scanner;



/**
 * The Class HexCalc.
 */
public class HexCalc {
	
	/** The sc. */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Gets the string.
	 *
	 * @return the string
	 */
	public static String getString(){
		
		while (true) {
			try {
					String str =sc.nextLine();
					return str.replaceAll("[^a-zA-Z0-9]", "");
				}
			catch (Exception ex) {
					System.out.println("Enter string value only :");
					sc.next();
				}
			}
	}
	
	/**
	 * Gets the char.
	 *
	 * @param c the c
	 * @return the char
	 */
	public static int getChar(char c) {
		if( c >= '0' && c<= '9' ) {
			return (c -'0');
		}else{
			return (c -'A'+10);
		}
	}
	
	/**
	 * This method convert number to equivalent character in notation according to the base.
	 *
	 * @param num represent number which will be converted
	 * @return the character in the respective notation
	 */
	public static char revChar(Integer num){
		if(num >=0 && num <=9)
			return (char) (num+'0');
		else
			return (char) (num + 'A' -10);
	}
	
	/**
	 * This method convert number of any base to decimal equivalent
	 *
	 * @param number represent the number with any base
	 * @param base represent the base of number
	 * @return the decimal equivalent of number
	 */
	public static Integer NBaseToDec(String number, Integer base) {
		int len = number.length();
		int power = 1;
		Integer dec = 0 ;
		
		for(int iterator = len -1; iterator >= 0; iterator-- ) {
			if( getChar(number.charAt(iterator)) >= base) {
				return Integer.MIN_VALUE;
			}
			else{
				dec += getChar(number.charAt(iterator)) * power;
				power = power * base;
			}
		}
		return dec;
	}
	
	/**
	 * This method convert decimal number to respective base
	 *
	 * @param dec represent the decimal number
	 * @param base represent the base to convert to
	 * @return the converted number in respective base
	 */
	public static String decToBaseN( Integer dec, Integer base){
		String result ="";
		while( dec > 0 ) {
			result += revChar( dec % base );
			dec /= base;
 		}
		String decm = "";
		char ch[] = result.toCharArray();
	    for(int iterator = ch.length - 1 ; iterator >= 0 ; iterator-- ) {  
	        decm += ch[iterator];  
	    } 
	    return decm;
	    	
	}
	
	/**
	 * this method compare the length of the numbers
	 *
	 * @param num1 represent number to be compared
	 * @param num2 represent number to be compared
	 * @return the bigger number or equal if the numbers are equal
	 */
	public static String compareLength(String num1 , String num2){
		int len1 = num1.length();
		int len2 = num2.length();
		if( len1 < len2 )
			return num2;
		else if( len1 > len2)
			return num1;
		else
			return "equal";
	}
	
	/**
	 * This method compare numbers are equal or not
	 *
	 * @param num1 represent number to be compared
	 * @param num2 represent number to be compared
	 * @return true, if equal, else return false
	 */
	public static boolean compareEqual(String num1, String num2) {
	
		String bigNum = compareLength(num1, num2);
		if( bigNum.equals(num1) )
			return false;
		else if ( bigNum.equals(num2) )
			return false;
		else{
			int len = num1.length();
			int diff;
			
			for(int iterator = 0 ; iterator < len ; iterator++ ){
				diff = num1.charAt(iterator) - num2.charAt(iterator) ;
				if( diff > 0 )
					return false;
				else if (diff < 0 )
					return false;
			}
		return true;
		}
		
	}
	
	/**
	 * this method compare the numbers for bigger number
	 *
	 * @param num1 represent number to be compared
	 * @param num2 represent number to be compared
	 * @return true, if num1 is greater than num2, else return false
	 */
	public static boolean compareGreater(String num1, String num2){
		String bigNum = compareLength(num1,num2);
		if( bigNum.equals(num1) )
			return true;
		else if ( bigNum.equals(num2) )
			return false;
		else {
			int len = num1.length();
			int diff;
			for(int iterator = 0 ; iterator < len ; iterator++ ){
				diff = num1.charAt(iterator) - num2.charAt(iterator);
				if( diff > 0 )
					return true;
				else if( diff < 0 )
					return false;
			}
			return false;
		}
	}
	
	/**
	 * this method compare the number for smaller number
	 *
	 * @param num1 represent number to be compared
	 * @param num2 represent number to be compared
	 * @return true, if num1 is smaller than num2, else return false
	 */
	public static boolean compareLesser(String num1, String num2){
		String bigNum = compareLength(num1,num2);
		if(bigNum.equals(num1))
			return false;
		else if (bigNum.equals(num2))
			return true;
		else {
			int len = num1.length();
			int diff;
			for(int iterator = 0 ; iterator < len ; iterator++ ) {
				diff = num1.charAt(iterator) - num2.charAt(iterator);
				if( diff > 0 )
					return false;
				else if( diff < 0 )
					return true;
			}
			return false;
		}
	}
	
	/**
	 * this method handle the functionality for comparing functions
	 *
	 * @param num1 represent number to be compared
	 * @param num2 represent number to be compared
	 */
	public static void compare( String num1, String num2){
		boolean flag = true ;
		boolean comflag;
		while (flag) {
			System.out.println("\n\nMenu \n"
					+ "1) Comapre for == \n"
					+ "2) Compare for < \n"
					+ "3) Compare for > \n"
					+ "4) Menu\n"
					+ "5) Exit\n"
					+ "Enter your choice... ");
			int choice = sc.nextInt();
			switch(choice ) {
				case 1:
						comflag = compareEqual(num1, num2);
						if( comflag )
							System.out.println("Both are Equal");
						else
							System.out.println(" Both are Not Equal");
						break;
				case 2:
						comflag = compareGreater(num1, num2);
						if( comflag )
							System.out.println(num1 + " is greater than "+ num2);
						else
							System.out.println(num1 + " is not greater than "+ num2);
						break;	
						
				case 3:
						comflag = compareLesser(num1, num2);
						if( comflag )
							System.out.println(num1 + " is lesser than "+ num2);
						else
							System.out.println(num1 + " is not lesser than "+ num2);
						break;
				case 4:
						flag = false;
						break;
				case 5: 
						System.exit(0);
				default: 
						System.out.println("Invalid Option");
						break;
				
			}
		}
	}
	
	
	/**
	 * This method manages all the arithmetic operations
	 *
	 * @param number1 represent number to be used for operation
	 * @param number2 represent number to be used for operation
	 * @param base represent the base of the number
	 */
	public static void calculate(String number1, String number2, Integer base){
		boolean flag = true;
		Integer num1,num2;
		while(flag){
			System.out.println("\n\nMenu :- \n"
					+ "1) Add the Numbers\n"
					+ "2) Subtract the Numbers\n"
					+ "3) Multiply the Numbers\n"
					+ "4) Divide the Numbers\n"
					+ "5) Menu\n"
					+ "6) Exit\n"
					+ "Enter your choice.... ");
			int choice = sc.nextInt();
			
			switch(choice){
			
				case 1:					
						System.out.println("Sum = "+ decToBaseN( ( NBaseToDec(number1,base) + NBaseToDec(number2, base) ), base) );
						break;
				case 2: 
						num1 = NBaseToDec(number1, base);
						num2 = NBaseToDec(number2, base);
						Integer sub;
						
						if ( num1 < num2 ){
							sub = num2 - num1;
						}else{
							sub = num1 - num2;
						}
						System.out.println("Sub = "+ decToBaseN(sub, base));
						break;
				case 3:
						System.out.println("Multiply = "+ decToBaseN( (NBaseToDec(number1,base) * NBaseToDec(number2, base) ), base) );
						break;
				case 4:
						num1 = NBaseToDec(number1, base);
						num2 = NBaseToDec(number2, base);
						Integer mul;
						
						if ( num1 < num2 ){
							mul = num2 / num1;
						}else{
							mul = num1 / num2;
						}
						System.out.println("Divide = "+ decToBaseN( mul, base ) );
						break;
				case 5:
						flag = false;
						break;
				case 6: 
						System.exit(0);
				default: 
						System.out.println("Invalid option");
						break;
			}
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main( String[] args) {
		String number1, number2;
		
		System.out.println("Enter the Number 1");
		number1 = getString();
		System.out.println(number1);
		System.out.println("Enter the Number 2");
		number2 = getString();
		
		System.out.println("Enter the base of number");
		Integer base = sc.nextInt();
		
		boolean flag = true;
		
		while(flag) {
			System.out.println("\n\nMenu :- \n"
					+ "1) Calculator\n"
					+ "2) Compare\n"
					+ "3) Exit\n"
					+ "Enter your choice.... ");
			int choice = sc.nextInt();
			
			switch(choice){
			
				case 1:					
						calculate(number1.toUpperCase(), number2.toUpperCase(), base);
						break;
				case 2: 
						compare(number1.toUpperCase(),number2.toUpperCase());
						break;
				case 3:
						flag =false;
						break;
				default: 
						System.out.println("Invalid Option");
						break;
					
			}
		}
	}
}
