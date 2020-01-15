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
					return sc.nextLine();
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
	 * Rev char.
	 *
	 * @param num the num
	 * @return the char
	 */
	public static char revChar(Integer num){
		if(num >=0 && num <=9)
			return (char) (num+'0');
		else
			return (char) (num + 'A' -10);
	}
	
	/**
	 * N base to dec.
	 *
	 * @param number the number
	 * @param base the base
	 * @return the integer
	 */
	public static Integer NBaseToDec(String number, Integer base) {
		int len = number.length();
		int power = 1;
		Integer dec = 0 ;
		
		for(int i= len -1; i>=0; i--){
			if(getChar(number.charAt(i)) >= base) {
				return Integer.MIN_VALUE;
			}
			else{
				dec+= getChar(number.charAt(i))*power;
				power = power*base;
			}
		}
		return dec;
	}
	
	/**
	 * Dec to base N.
	 *
	 * @param dec the dec
	 * @param base the base
	 * @return the string
	 */
	public static String decToBaseN( Integer dec, Integer base){
		String result ="";
		while(dec > 0){
			result +=revChar(dec%base);
			dec /= base;
 		}
		String decm = "";
		char ch[] = result.toCharArray();
	    for(int i=ch.length-1;i>=0;i--){  
	        decm+=ch[i];  
	    } 
	    return decm;
	    	
	}
	
	/**
	 * Comp len.
	 *
	 * @param num1 the num 1
	 * @param num2 the num 2
	 * @return the string
	 */
	public static String compLen(String num1 , String num2){
		int len1 = num1.length();
		int len2 = num2.length();
		if(len1 < len2 )
			return num2;
		else if( len1 > len2)
			return num1;
		else
			return "equal";
	}
	
	/**
	 * Comp equal.
	 *
	 * @param num1 the num 1
	 * @param num2 the num 2
	 * @return true, if successful
	 */
	public static boolean compEqual(String num1, String num2) {
	
		String bigNum = compLen(num1, num2);
		if(bigNum.equals(num1))
			return false;
		else if (bigNum.equals(num2))
			return false;
		else{
			int len = num1.length();
			int diff;
			for(int i=0;i<len;i++){
				diff=num1.charAt(i)-num2.charAt(i);
				if(diff>0)
					return false;
				else if(diff <0)
					return false;
			}
		return true;
		}
		
	}
	
	/**
	 * Comp great.
	 *
	 * @param num1 the num 1
	 * @param num2 the num 2
	 * @return true, if successful
	 */
	public static boolean compGreat(String num1, String num2){
		String bigNum = compLen(num1,num2);
		if(bigNum.equals(num1))
			return true;
		else if (bigNum.equals(num2))
			return false;
		else {
			int len = num1.length();
			int diff;
			for(int i=0;i<len;i++){
				diff=num1.charAt(i)-num2.charAt(i);
				if(diff>0)
					return true;
				else if(diff <0)
					return false;
			}
			return false;
		}
	}
	
	/**
	 * Comp less.
	 *
	 * @param num1 the num 1
	 * @param num2 the num 2
	 * @return true, if successful
	 */
	public static boolean compLess(String num1, String num2){
		String bigNum = compLen(num1,num2);
		if(bigNum.equals(num1))
			return false;
		else if (bigNum.equals(num2))
			return true;
		else {
			int len = num1.length();
			int diff;
			for(int i=0;i<len;i++){
				diff=num1.charAt(i)-num2.charAt(i);
				if(diff>0)
					return false;
				else if(diff <0)
					return true;
			}
			return false;
		}
	}
	
	/**
	 * Compare.
	 *
	 * @param num1 the num 1
	 * @param num2 the num 2
	 */
	public static void compare( String num1, String num2){
		boolean flag = true ;
		boolean comflag;
		while (flag) {
			System.out.println("\n\nMenu \n"
					+ "1) Comapre for == \n"
					+ "2) Compare for < \n"
					+ "3) Compare for > \n]"
					+ "4) Menu\n"
					+ "Enter your choice... ");
			int choice = sc.nextInt();
			switch(choice ) {
				case 1:
						comflag = compEqual(num1,num2);
						if(comflag)
							System.out.println("Both are Equal");
						else
							System.out.println(" Both are Not Equal");
						break;
				case 2:
						comflag = compGreat(num1,num2);
						if(comflag)
							System.out.println(num1 + " is greater than "+ num2);
						else
							System.out.println(num1 + " is not greater than "+ num2);
						break;	
						
				case 3:
						comflag = compLess(num1,num2);
						if(comflag)
							System.out.println(num1 + " is lesser than "+ num2);
						else
							System.out.println(num1 + " is not lesser than "+ num2);
						break;
				case 4:
						flag = false;
						break;
				default: 
						System.out.println("Invalid Option");
						break;
				
			}
		}
	}
	
	
	/**
	 * Calc.
	 *
	 * @param number1 the number 1
	 * @param number2 the number 2
	 * @param base the base
	 */
	public static void calc(String number1, String number2, Integer base){
		boolean flag = true;
		Integer num1,num2;
		while(flag){
			System.out.println("\n\nMenu :- \n"
					+ "1) Add the Numbers\n"
					+ "2) Subtract the Numbers\n"
					+ "3) Multiply the Numbers\n"
					+ "4) Divide the Numbers\n"
					+ "5) Menu\n"
					+ "Enter your choice.... ");
			int choice = sc.nextInt();
			
			switch(choice){
			
				case 1:					
						System.out.println("Sum = "+ decToBaseN((NBaseToDec(number1,base) + NBaseToDec(number2, base)), base));
						break;
				case 2: 
						num1 = NBaseToDec(number1, base);
						num2 = NBaseToDec(number2, base);
						Integer sub;
						
						if (num1 < num2){
							sub = num2-num1;
						}else{
							sub = num1 -num2;
						}
						System.out.println("Sub = "+ decToBaseN(sub, base));
						break;
				case 3:
						System.out.println("Multiply = "+ decToBaseN((NBaseToDec(number1,base) * NBaseToDec(number2, base)), base));
						break;
				case 4:
						num1 = NBaseToDec(number1, base);
						num2 = NBaseToDec(number2, base);
						Integer mul;
						
						if (num1 < num2){
							mul = num2/num1;
						}else{
							mul = num1/num2;
						}
						System.out.println("Divide = "+ decToBaseN(mul, base));
						break;
				case 5:
						flag = false;
						break;
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
						calc(number1.toUpperCase(), number2.toUpperCase(), base);
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
