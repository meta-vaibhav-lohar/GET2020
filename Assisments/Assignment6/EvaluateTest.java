
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
@RunWith(Parameterized.class)
public class EvaluateTest {
	   private int[][] polynomialArray;
	   private int valueOfX;
	   private int expectedResult;
	   public EvaluateTest(int[][] polynomialArray,int valueOfX,int expectedResult) {
		 this.polynomialArray=polynomialArray;
		 this.valueOfX=valueOfX;
		 this.expectedResult=expectedResult;
	   }

	   @Parameterized.Parameters
	   public static Collection evaluator() {
	      return Arrays.asList(new Object[][] {
	    		  {new int[][]{{3,4},{2,2},{0,-1} },2,39},
	    		  {new int[][]{{8,4},{0,-1} },2,1023},
	    		  {new int[][]{{3,4},{2,-1},{1,-4}},8,1952}
		      });
		   }
		   @Test
		   public void evaluateTest(){
			  Polynomial polynomial=new Polynomial(polynomialArray);
			  assertEquals(expectedResult,polynomial.evaluate(valueOfX));
		   }

	}