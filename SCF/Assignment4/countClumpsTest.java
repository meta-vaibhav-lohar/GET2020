import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


/**
 * The Class countClumpsTest.
 */
@RunWith(Parameterized.class)
public class countClumpsTest {
	   
   	/** The input array. */
   	private int[]inputArray;
	   
   	/** The expected result. */
   	private int expectedResult;
	  
	   /**
   	 * Initialize.
   	 */
   	@Before
	   public void initialize() {
		   new ArrOperations();
	   }

	 
		
	/**
   	 * Instantiates a new count clumps test.
   	 *
   	 * @param expectedResult the expected result
   	 * @param inputArray the input array
   	 */
   	public countClumpsTest(int expectedResult,int[] inputArray) {
	   this.expectedResult=expectedResult;
	   this.inputArray=inputArray;
	   }

	   /**
   	 * Jobscheduler.
   	 *
   	 * @return the collection
   	 */
   	@Parameterized.Parameters
	   public static Collection<Object[]> jobscheduler() {
	      return Arrays.asList(new Object[][] {
	         { 2,new int[] {1,1,2,2,2,2}},
	 		 { 3,new int[] {1,1,2,2,3,3}},
			 { 1,new int[] {1,1,1,1,1}},
			 { 3,new int[] {1,1,2,2,3,3,3,3}},
			 { 0,new int[] {1,2,3,4}}
			 	         
	      });
	   }

	/**
	 * Count clump test.
	 */
	@Test
	public void countClumpTest() {
		assertEquals(expectedResult,ArrOperations.countClumps(inputArray));
	}

}