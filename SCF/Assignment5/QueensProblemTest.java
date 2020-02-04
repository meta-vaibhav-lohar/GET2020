import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert;

/**
 * The Class QueensProblemTest.
 */
public class QueensProblemTest {
	
	/**
	 * Queens problem test 1.
	 */
	@Test (expected = AssertionError.class)
	public void QueensProblemTest1(){
		try{
			NQueensProblem.calculateQueens(1);
		}
		catch (Exception e){
			assertEquals("The size of the matrix should be greater than 3.",e.getMessage());
		}
	}
}