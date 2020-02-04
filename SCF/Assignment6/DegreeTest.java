
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DegreeTest {
	   private int[][] polynomialArray;
	   private int expectedResult;
	   public DegreeTest(int[][] polynomialArray,int expectedResult) {
		 this.polynomialArray=polynomialArray;
		 this.expectedResult=expectedResult;
	   }

	   @Parameterized.Parameters
	   public static Collection evaluator() {
	      return Arrays.asList(new Object[][] {
	    		  {new int[][]{{3,4},{2,2},{0,-1} },3},
	    		  {new int[][]{{8,4},{0,-1} },8},
	    		  {new int[][]{{3,4},{2,-1},{1,-4}},3}
		      });
		   }
		   @Test
		   public void evaluateTest(){
			  Polynomial polynomial=new Polynomial(polynomialArray);
			  assertEquals(expectedResult,polynomial.degree());
		   }

	}