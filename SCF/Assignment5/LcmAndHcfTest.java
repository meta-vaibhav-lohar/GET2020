import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Assert;

/**
 * The Class LcmAndHcfTest.
 */
public class LcmAndHcfTest {
	
	/**
	 * Test hcf part 1.
	 */
	@Test (expected = AssertionError.class)
	public void TestHcfPart1(){
		
		try { 
			LCMandHCF.hcf(0,0); 
		}
		catch (Exception e) { 
			assertEquals("Both numbers can't be zero", e.getMessage());
		}

	}

	/**
	 * Test hcf part 2.
	 */
	@Test  (expected = AssertionError.class)
	public void TestHcfPart2(){
		try { 
			LCMandHCF.hcf(2,-1); 
		}
		catch (Exception e) { 
			assertEquals("Number should be positive", e.getMessage());
		}
	}
	
	/**
	 * Test hcf 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void TestHcf1() throws Exception{
		assertEquals(1,LCMandHCF.hcf(0,1));
	}
	
	/**
	 * Test hcf 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void TestHcf2() throws Exception{
		assertEquals(1,LCMandHCF.hcf(1,0));
	}
	
	/**
	 * Test hcf 3.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void TestHcf3() throws Exception{
		assertEquals(5,LCMandHCF.hcf(10,5));
	}
	
	/**
	 * Test hcf 4.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void TestHcf4() throws Exception{
		assertEquals(5,LCMandHCF.hcf(5,10));
	}

	/**
	 * Test lcm part 1.
	 */
	//Test cases for LCM function.
	@Test  (expected = AssertionError.class)
	public void TestLcmPart1(){
		try { 
			LCMandHCF.lcm(0,1); 
		}
		catch (Exception e) { 
			assertEquals("Numbers can't be zero", e.getMessage());
		}

	}
	
	/**
	 * Test lcm part 2.
	 */
	@Test  (expected = AssertionError.class)
	public void TestLcmPart2(){
		try { 
			LCMandHCF.lcm(1,0); 
		}
		catch (Exception e) { 
			assertEquals("Numbers can't be zero", e.getMessage());
		}

	}
	
	/**
	 * Test hcf part 3.
	 */
	@Test  (expected = AssertionError.class)
	public void TestHcfPart3(){
		try { 
			LCMandHCF.hcf(2,-1); 
		}
		catch (Exception e) { 
			assertEquals("Number should be positive", e.getMessage());
		}

	}

	/**
	 * Test lcm 1.
	 *
	 * @throws Exception the exception
	 */
	@Test 
	public void TestLcm1() throws Exception{
		assertEquals(10,LCMandHCF.lcm(5,10));
	}
}