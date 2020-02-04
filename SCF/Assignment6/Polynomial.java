public class Polynomial {
	private int[][] poly;
	public Polynomial(int[][] poly){
		if(poly.length==0){
			throw new NullPointerException();
		}
		this.poly=poly;
		if(poly[0].length>2){
			throw new AssertionError();
		}
	}
	/**
	 * converts one dimensional array into two dimensional array 
	 * @param polynomial one dimensional array
	 * @return two dimensional array only non zero coefficients are allowed
	 */
	
	private int[][] convertArray(int[] polynomial){
		int counter=0,counterMarker=0;
		for(int i=0;i<polynomial.length;i++) {
			if(polynomial[i]!=0) {
				counter++;
			}
		}
		int[][] polynomialArray=new int[counter][2];
		for(int i=polynomial.length-1;i>=0;i--) {
			if(polynomial[i]!=0) {
				polynomialArray[counterMarker][0]=i;
				polynomialArray[counterMarker][1]=polynomial[i];
				counterMarker++;
			}
		}
		return polynomialArray;
	}
	/**
	 * evaluate value of polynomial for a given value x
	 * @param valueOfX it could be any number,valueOfX is always Integer
	 * @return integer value of polynomial 
	 */
	public int evaluate(int valueOfX) {
		int sum=0;
		for(int i=0;i<poly.length;i++){
			sum= (int)(sum+(Math.pow(valueOfX, poly[i][0]))*poly[i][1]);
		}
		return sum;
	}
	/**
	 * finds the highest degree of its polynomial (individual terms) with non-zero coefficients
	 * @return highest degree of calling polynomial
	 */
	public int degree() {
		int maxDegree=0;
		for(int i=0;i<poly.length;i++) {
			//System.out.println(maxDegree);
			if(poly[i][0]>maxDegree) {
				
				maxDegree=poly[i][0];
			}
		}
		//System.out.println(maxDegree);
		return maxDegree;
	}
	/**
	 * adds two polynomial
	 * @param Polynomial must not refer to null
	 * @return polynomial
	 */
	public Polynomial addPolynomial(Polynomial Polynomial) {
		int size;
		int counter=0;
		int coefficientForPolynomial,coefficientForPolynomial2;
		if(Polynomial.degree()>degree()){
			size=Polynomial.degree();
		}
		else{
			size=this.degree();
		}
		int[][] poly1=new int[size+1][2];
		for(int i=size;i>=0;i--){
			coefficientForPolynomial=Polynomial.getCoefficient( i);
			coefficientForPolynomial2=getCoefficient( i);
			if(coefficientForPolynomial!=0 || coefficientForPolynomial2!=0 ) {
			  poly1[counter][0]=i;
			  poly1[counter][1]=coefficientForPolynomial+coefficientForPolynomial2;
			  counter++;
			}
		}
		
		int[][] poly2=new int[counter][2];
		for(int i=0;i<counter;i++) {
			poly2[i]=poly1[i];
		}
		Polynomial polynomial=new Polynomial(poly2);
		return polynomial;
	}
	/**
	 * finds coefficient of given power
	 * @param power it should always be greater than zero
	 * @return returns positive coefficient if coefficient doen't exist returns 0
	 */
	private int getCoefficient(int power){
		for(int i=0;i<poly.length;i++){
			if(poly[i][0]==power){
				return poly[i][1];
			}
		}
		return 0;
		
	}
	/**
	 * 
	 * @return polynomial array of polynomial class
	 */
	public int[][] getSetValue(){
		return poly;
	}
    /**
     * multiply two polynomials
     * @param polynomial 
     * @return returns new polynomial
     */
	public Polynomial multiply(Polynomial polynomial){
		int[] temporaryArray=new int[polynomial.degree()+degree()+1];                                                                                                                                                        
		for(int i=0;i<polynomial.poly.length;i++){
			for(int j=0;j<poly.length;j++){
				temporaryArray[polynomial.poly[i][0]+poly[j][0]]+=polynomial.poly[i][1]*poly[j][1];
			}
		}
		int[][] poly1=convertArray(temporaryArray);
		return new Polynomial(poly1);
	}
	

}