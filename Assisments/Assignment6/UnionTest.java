
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UnionTest {
	   private int[] setArray;
	   private int[] setArray1;
	   private int[] expectedArray;
	   public UnionTest(int[] expectedArray,int[] setArray,int[] setArray1) {
		 this.expectedArray=expectedArray;
	     this.setArray=setArray;
	     this.setArray1=setArray1;
	   }

	   @Parameterized.Parameters
	   public static Collection jobscheduler() {
	      return Arrays.asList(new Object[][] {
	         {new int[]{1,2,3,4,5,6,7,8,9,10},new int[]{2,5,7,8,9},new int[]{1,3,4,5,7,8,9,10}},
	         
	      });
	   }
	   @Test
	   public void unionTest(){
		   intSet set1=new intSet(setArray);
		   intSet set2=new intSet(setArray1);
		   intSet set3=new intSet(expectedArray);
		   assertEquals(set3,set1.union(set2));
	   }

}