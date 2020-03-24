package ques3;

public class Variable {
	
	private char varibleName;
	private int variablePower;
	
	/**
	 * Constructor to initialize the data members of the class
	 * @param variableName is the variable name(x or y or z or etc.)
	 * @param variablePower is the variable power
	 */
	Variable(char variableName, int variablePower)
	{
		this.variablePower  = variablePower;
		this.varibleName = variableName;
	}

	/**
	 * This method returns the name of the variable
	 * @return {String} name of the variable
	 */
	public char getVaribleName() {
		return varibleName;
	}
	/**
	 * This method returns the power of the variable
	 * @return {int} power of the variable
	 */
	public int getVariablePower() {
		return variablePower;
	}

}