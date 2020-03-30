package ques3;

public class Element {
	
	private char symbol;
    private int base;

    /**
     * Constructor to initialize the data members of the class
     * @param symbol is the symbol
     * @param base is the symbol's base
     */
    Element(char symbol, int base)
    {
        this.symbol = symbol;
        this.base = base;
    }
    
    /**
     * This method returns the symbol
     * @return {char}
     */
    char getSymbol()
    {
        return symbol;
    }
    
    /**
     * This method returns the base of the symbol
     * @return {int}
     */
    int getBase()
    {
        return base;
    }
}