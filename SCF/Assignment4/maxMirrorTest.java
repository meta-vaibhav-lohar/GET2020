import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * The Class maxMirrorTest.
 */
@RunWith(Parameterized.class)
public class maxMirrorTest {
	
	   /** The input array. */
   	private int[]inputArray;
	   
   	/** The expected result. */
   	private int expectedResult;
	  
	   /** The array operations. */
   	private ArrOperations arrOperations;

	   /**
   	 * Initialize.
   	 */
   	@Before
	   public void initialize() {
		   arrOperations=new ArrOperations();
	   }

	 
		
	   /**
   	 * Instantiates a new max mirror test.
   	 *
   	 * @param expectedResult the expected result
   	 * @param inputArray the input array
   	 */
   	public maxMirrorTest(int expectedResult,int[] inputArray) {
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
	    	 { 3,new int[] {1,2,3,8,9,3,2,1}},
	  		 { 4,new int[] {1,1,2,2,2,2}},
	  		 { 2,new int[] {1,1,2,2,3,3}},
	  		 { 5,new int[] {1,1,1,1,1}},
	  		 { 3,new int[] {1,2,3,8,9,3,2,1}},
	  		 { 5,new int[] {1,2,3,2,1}},
	  	   	 { 4,new int[] {7,7,7,7,6,7}}	
		
	         
	      });
	   }
	   
   	/**
   	 * Max mirror test.
   	 */
   	@Test
		public void maxMirrorTest() {
			assertEquals(expectedResult,arrOperations.maxMirror(inputArray));
		}}
