import static org.junit.Assert.*;

import org.junit.Test;

public class SparseMatrixTest {

	@Test
	public void test() {
		Matrix Matrix1=new Matrix(new int[][] {{1,1,1}, {2,2,1},{2,3,1},{3,1,2},{3,2,1}},3,3);
		Matrix Matrix=new Matrix(new int[][] {{1,1,1}, {1,2,1},{2,3,1},{3,1,2},{3,3,1}},3,3);
		//Matrix Matrix3=new Matrix(new int[][] {{1,1,1}, {1,2,1},{2,3,1},{3,1,2},{3,3,1}},3,3);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},{2,3,2},{3,1,4},{3,2,1},{3,3,1}},Matrix.addMatrice(Matrix1).getarray());
		assertArrayEquals(new int[][] {{1,1,1},{1,2,1},{1,3,1},{2,1,2},{2,2,1},{3,1,4},{3,2,1}},Matrix.multiply(Matrix1).getarray());
	}
	@Test
	public void addMatricesTest() {
		Matrix Matrix=new Matrix(new int[][] {{1,1,1}, 
																	{1,2,1},
																	{2,3,1},
																	{3,1,2},
																	{3,3,1}},3,3);
		Matrix Matrix1=new Matrix(new int[][] {{1,1,1},
																	{2,2,1},
																	{2,3,1},
																	{3,1,2},{3,2,1}},3,3);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},
			{2,3,2},{3,1,4},{3,2,1},{3,3,1}},Matrix.addMatrice(Matrix1).getarray());
	}
	@Test
	public void multiplytest() {
			Matrix Matrix=new Matrix(new int[][] {{1,1,1}, 
																		{1,2,1},
																		{2,3,1},
																		{3,1,2},
																		{3,3,1}},3,3);
			Matrix Matrix1=new Matrix(new int[][] {{1,1,1},
																		{2,2,1},
																		{2,3,1},
																		{3,1,2},{3,2,1}},3,3);
			assertArrayEquals(new int[][] {{1,1,1},{1,2,1},{1,3,1},
				{2,1,2},{2,2,1},{3,1,4},{3,2,1}},Matrix.multiply(Matrix1).getarray());
			
	}
	@Test
	public void transposeTest() {
		Matrix Matrix=new Matrix(new int[][] {{1,1,1}, 
			{1,2,1},
			{2,3,1},
			{3,1,2},
			{3,3,1}},3,3);
		assertArrayEquals(new int[][] {{1,1,1},{1,3,2},{2,1,1},{3,2,1},{3,3,1}},Matrix.transpose().getarray());
	}
	@Test
	public void isSymmetricTest() {
		Matrix Matrix=new Matrix(new int[][] {{1,1,5}, 
			{1,3,3},
			{2,2,1},
			{3,1,3},
			{3,3,5}},3,3);
		assertEquals(true,Matrix.isSymmetric());
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfMatrxIsEmpty() {
		Matrix Matrix=new Matrix(new int[][] {},3,3);
	}
	//applied to addition method
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSizeOfMatricesAreNotSame() {
		Matrix Matrix=new Matrix(new int[][] {{1,1,1}, 
			{1,2,1},
			{2,3,1},
			{3,1,2},
			{3,3,1}},3,3);
		Matrix Matrix1=new Matrix(new int[][] {{1,1,1},
			{2,2,1},
			{2,3,1},
			{3,1,2},{3,2,1}},3,4);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},
			{2,3,2},{3,1,4},{3,2,1},{3,3,1}},Matrix.addMatrice(Matrix1).getarray());
	}
	//applied to multiply method
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfRow1AndColumn2OfMatricesAreNotSame() {
		Matrix Matrix=new Matrix(new int[][] {{1,1,1}, 
			{1,2,1},
			{2,3,1},
			{3,1,2},
			{3,3,1}},3,3);
		Matrix Matrix1=new Matrix(new int[][] {{1,1,1},
			{2,2,1},
			{2,3,1},
			{3,1,2},{3,2,1}},5,4);
		assertArrayEquals(new int[][] {{1,1,2},{1,2,1},{2,2,1},
			{2,3,2},{3,1,4},{3,2,1},{3,3,1}},Matrix.multiply(Matrix1).getarray());
	}
	

}