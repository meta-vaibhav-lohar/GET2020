import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The Class exceptionHandlingTest.
 */
public class exceptionHandlingTest {
		
		/** The arroperation. */
		ArrOperations arroperation=new ArrOperations();

	/**
	 * Max mirrorthrows assertion error if array is null.
	 */
	@Test
	public void maxMirrorthrowsAssertionErrorIfArrayIsNull() {
		
		 assertThrows(AssertionError.class, () -> {
			 ArrOperations.maxMirror(new int[]{});
	        });
	}
	
	/**
	 * Count clumpthrows assertion error if array is null.
	 */
	@Test
	public void countClumpthrowsAssertionErrorIfArrayIsNull() {
		
		 assertThrows(AssertionError.class, () -> {
			 ArrOperations.countClumps(new int[]{});
	        });
	}
	
	/**
	 * Split sumthrows assertion error if array is null.
	 */
	@Test
	public void splitSumthrowsAssertionErrorIfArrayIsNull() {
		
		 assertThrows(AssertionError.class, () -> {
			 ArrOperations.splitArray(new int[]{});
	        });
	}
	
	/**
	 * Fix X ythrows exceptions.
	 */
	@Test
	public void fixXYthrowsExceptions() {
		
		 assertThrows(AssertionError.class, () -> {
			 ArrOperations.fixXY(new int[]{}, 4,5);
	});
		 assertThrows(AssertionError.class, () -> {
			 ArrOperations.fixXY(new int[]{4,5,1,5,4},4,5);
	});
		 assertThrows(AssertionError.class, () -> {
			 ArrOperations.fixXY(new int[]{4,5,1,5,4},4,5);
	});
		 assertThrows(AssertionError.class, () -> {
			 ArrOperations.fixXY(new int[]{1,1,3,2,2},1,2);
	});
		
		 
	}
}
