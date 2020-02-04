import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/**
 * The Class splitArrayTest.
 */
@RunWith(Parameterized.class)


public class splitArrayTest {

	   /** The arr operations. */
   	private ArrOperations arrOperations;
	
	/** The expected result. */
	private int expectedResult;
	
	/** The input array. */
	private int[] inputArray;

	   /**
   	 * Initialize.
   	 */
   	@Before
	   public void initialize() {
		   arrOperations=new ArrOperations();
	   }
	   
	   /**
   	 * Instantiates a new split array test.
   	 *
   	 * @param expectedResult the expected result
   	 * @param inputArray the input array
   	 */
   	public splitArrayTest( int expectedResult, int[] inputArray){
		   this.expectedResult=expectedResult;
		   this.inputArray=inputArray;
		  
	   }
	   
   	/**
   	 * Jobscheduler.
   	 *
   	 * @return the collection
   	 */
   	@Parameterized.Parameters
	   public static Collection jobscheduler() {
	      return Arrays.asList(new Object[][] {
	    			{-1,new int[] {1,1,2,2,2,2}},
	    			{3,new int[] {1,1,1,1,2}},
	    			{3,new int[] {1,1,1,1,1,1}},
	    			{5,new int[] {1,1,2,2,3,3,3,3}},
	    			{-1,new int[] {1,2,3,4}}
	      });
	   }
	   
   	/**
   	 * Split array test.
   	 */
   	@Test
		public void splitArrayTest() {
			assertEquals(expectedResult,arrOperations.splitArray(inputArray));
		}
}
