import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;

/**
 * The Class SearchTest.
 */
public class SearchTest {
	
	/**
	 * Testlinear search.
	 */
	@Test
	public void testlinearSearch() {
		try {
			Search.linearSearchCall(new int[] {}, 0);
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	/**
	 * Testlinear search 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testlinearSearch1() throws Exception {
		assertEquals(1, Search.linearSearchCall(new int[] { 1, 2, 2, 3, 4, 4 }, 2));
	}

	/**
	 * Testlinear search 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testlinearSearch2() throws Exception {
		assertEquals(6,
				Search.linearSearchCall(new int[] { 4, 4, 4, 6, 9, 1, 2, 3 }, 2));
	}

	/**
	 * Testlinear search 3.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testlinearSearch3() throws Exception {
		assertEquals(0, Search.linearSearchCall(new int[] { 4, 4, -1, 6, 9, 0, 2, -2 }, 4));
	}

	/**
	 * Testlinear search 4.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testlinearSearch4() throws Exception {
		assertEquals(1, Search.linearSearchCall(new int[] {0 ,4}, 4));
	}

	/**
	 * Testlinear search 5.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testlinearSearch5() throws Exception {
		assertEquals(0, Search.linearSearchCall(new int[] {4}, 4));
	}

	/**
	 * Testbinary search.
	 */
	@Test
	public void testbinarySearch() {
		try {
			Search.linearSearchCall(new int[] {}, 0);
		} catch (Exception e) {
			assertEquals("Array is empty.", e.getMessage());
		}
	}

	/**
	 * Testbinary search 1.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testbinarySearch1() throws Exception {
		assertEquals(2, Search.binarySearchCall(new int[] { 1, 2, 2, 3, 4, 4 }, 2));
	}

	/**
	 * Testbinary search 2.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testbinarySearch2() throws Exception {
		assertEquals(-1, Search.binarySearchCall(new int[] { 4 }, 9));
	}

}