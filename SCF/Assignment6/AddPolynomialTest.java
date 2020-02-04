import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AddPolynomialTest {
	   private int[][] polynomialArray1;
	   private int[][] polynomialArray2;
	   private int[][] expectedPolynomialArray;
	   public AddPolynomialTest(int[][] polynomialArray1,int[][] polynomialArray2,int[][] expectedPolynomialArray) {
		 this.polynomialArray1=polynomialArray1;
		 this.polynomialArray2=polynomialArray2;
		 this.expectedPolynomialArray=expectedPolynomialArray ;
	   }
	   @Parameterized.Parameters
	   public static Collection evaluator() {
	      return Arrays.asList(new Object[][] {
	    		  {new int[][]{{2,1},{0,1}},new int[][]{{8,1},{0,1}},new int[][]{{8,1},{2,1},{0,2}}},
	    		  {new int[][]{{2,1},{1,1},{0,1}},new int[][]{{2,1},{1,1},{0,1}},new int[][]{{2,2},{1,2},{0,2}}},
	    		  {new int[][]{{10,4},{0,7}},new int[][]{{9,4},{1,1}},new int[][]{{10,4},{9,4},{1,1},{0,7}}}
		      });
		   }
		   @Test
		   public void addPolynomialTest(){
			  Polynomial Polynomial=new Polynomial(polynomialArray1);
			  Polynomial polynomial2 = new Polynomial(polynomialArray2);
			  Polynomial polynomial3=new Polynomial(expectedPolynomialArray);
			  assertArrayEquals(polynomial3.getSetValue(),(Polynomial.addPolynomial(polynomial2).getSetValue()));
		   }

	}