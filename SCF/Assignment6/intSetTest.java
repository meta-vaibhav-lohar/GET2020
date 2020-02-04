import static org.junit.Assert.*;

import java.util.Arrays;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Test;

public class intSetTest {

	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetIsEmpty(){
		intSet intSet=new intSet(new int[]{});
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetHasRepeatedElements(){
		intSet intSet=new intSet(new int[]{1,3,2,2,4});
	}
	
	@Test(expected=AssertionError.class)
	public void throwsAssertionErrorIfSetIsNotInRange(){
		intSet intSet=new intSet(new int[]{1,3,5,1111});
	}
	@Test
	public void isMemberTest(){
		intSet intSet=new intSet(new int[]{1,3,5,8,12,15,18,40});
		assertEquals(true,intSet.isMember(5));
		assertEquals(false,intSet.isMember(2));
		assertNotEquals(false,intSet.isMember(12));
	}
	@Test
	public void isSubSetTest(){
		intSet intSet=new intSet(new int[]{1,3,5,8,12,15,18,40});
		assertEquals(true,intSet.isSubSet(new intSet(new int[]{8,15})));
		assertEquals(true,intSet.isSubSet(new intSet(new int[]{8,15,40})));
		assertEquals(true,intSet.isSubSet(new intSet(new int[]{1,3,5,8,12,15,18,40})));
		assertNotEquals(false,intSet.isSubSet(new intSet(new int[]{1,3,5,8,12,15,18,40})));
	}
	@Test
	public void complimentTest(){
		intSet intSet=new intSet(new int[]{1,3,5,8,12,15,18,40});
		int[] expectedArray=new int[1000-intSet.size()];
		int j=0;
		for(int i=0;i<1000;i++){
			if(!(intSet.isMember(i+1))){
				expectedArray[j]=i+1;
				j++;}		
		}
		System.out.println(Arrays.toString(expectedArray));
		int[] arra=intSet.compliment().getSetArray();
		for(int i=0;i<arra.length;i++){
			//System.out.println("test"+arra[i]);
		}
		assertArrayEquals(expectedArray,(intSet.compliment()).getSetArray());
	}
	@Test
	public void unionTest() {
		intSet intSet=new intSet(new int[]{1,3,5,8,12,15,18,40});
		assertArrayEquals(new int[]{1,3,5,8,12,15,18,40,2,4,7},intSet.union(new intSet(new int[] {3,2,5,4,7,8})).getSetArray());
		intSet intSet1=new intSet(new int[] {1,4,6,2,8});
		assertArrayEquals(new int[]{1,4,6,2,8},intSet1.union(new intSet(new int[] {1,4,6,2,8})).getSetArray());
		assertThat(new int[]{1,4,6,2,8}, IsNot.not(IsEqual.equalTo(intSet.union(new intSet(new int[] {3,2,5,4,7,8})).getSetArray())));
				
	}
}