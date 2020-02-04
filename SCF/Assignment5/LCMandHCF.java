
/**
 * The Class LCMandHCF.
 */
public class LCMandHCF {
	
	/**
	 * Hcf.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @return the HCF
	 */
	public static int hcf( int firstNumber, int secondNumber){
		
		if(firstNumber == 0 && secondNumber == 0)
			throw new AssertionError("Both numbers can't be zero");
		if(firstNumber < 0 || secondNumber < 0)
			throw new AssertionError("Number should be positive");
		if( secondNumber != 0)
			return hcf(secondNumber, firstNumber%secondNumber);
		
		else
			return firstNumber;
		
		
	}
	
	/**
	 * Lcm.
	 *
	 * @param firstNumber the first number
	 * @param secondNumber the second number
	 * @return the LCM
	 */
	public static int lcm(int firstNumber, int secondNumber){
		if(firstNumber == 0 ||  secondNumber == 0)
			throw new AssertionError("Numbers can't be zero");
		return (firstNumber*secondNumber)/hcf(firstNumber,secondNumber);
	}
	
}
