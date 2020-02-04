
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * The Class fixXYTest.
 */
@RunWith(Parameterized.class)
public class fixXYTest{
	   
   	/** The input array. */
   	private int[]inputArray;
	   
   	/** The expected result. */
   	private int[] expectedResult;
	   
   	/** The x. */
   	private int x;
	   
   	/** The y. */
   	private int y;
	  
	   /** The arr operations. */
   	private ArrOperations arrOperations;

	   /**
   	 * Initialize.
   	 */
   	@Before
	   public void initialize() {
		   arrOperations=new ArrOperations();
	   }

	 
		
	   /**
   	 * Instantiates a new fix XY test.
   	 *
   	 * @param expectedResult the expected result
   	 * @param inputArray the input array
   	 * @param x the x
   	 * @param y the y
   	 */
   	public fixXYTest(int[] expectedResult,int[] inputArray,int x,int y) {
	   this.expectedResult=expectedResult;
	   this.inputArray=inputArray;
	   this.x=x;
	   this.y=y;
	   }

	   /**
   	 * Jobscheduler.
   	 *
   	 * @return the collection
   	 */
   	@Parameterized.Parameters
	   public static Collection jobscheduler() {
	      return Arrays.asList(new Object[][] {
	    	 {new int[] {9, 4, 5, 4, 5, 9},new int[]{5, 4, 9, 4, 9, 5},4,5},
	  		 {new int[] {1, 4, 5, 1},new int[]{1, 4, 1, 5},4,5},
	  		 { new int[] {1,2,3,1},new int[]{1,2,1,3},2,3}
		
	         
	      });
	   }
	   
   	/**
   	 * Fix XY test.
   	 */
   	@Test
		public void fixXYTest() {
			assertArrayEquals(expectedResult,arrOperations.fixXY(inputArray, x, y));
		}
}
