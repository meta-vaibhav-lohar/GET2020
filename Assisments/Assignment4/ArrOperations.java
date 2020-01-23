import java.util.ArrayList;

/**
 * The Class ArrOperations.
 */
public class ArrOperations {
	
	/**
	 * Instantiates a new array operations.
	 */
	public  ArrOperations() {
	}
	
	/**
	 * Max mirror.
	 *
	 * @param inputArray represents the input array
	 * @return the size of the largest mirror section found in the input array 
	 */
	public static int maxMirror(int[] inputArray){
		int len = inputArray.length;
		if(len == 0)
			throw new AssertionError("Array is empty ");
				 
		int count = 0;
		int max = 0;
		for( int leftIterator = 0; leftIterator < len; leftIterator++   ){
			count = 0;
			for( int rightIterator = len - 1; (rightIterator > -1) && (leftIterator + count < len); rightIterator-- ){
				if( inputArray[leftIterator + count ] == inputArray[rightIterator] ){
					count++;	
				}else if( count > 0 ){
						max = count > max ? count : max;
						count = 0;
				}			
			}
			max = count > max ? count : max;
		}
		return max;
	}
	
	
	/**
	 * Count clumps.
	 *
	 * @param inputArray represents the input array
	 * @return the number of clumps in the input array
	 */
	public static int countClumps(int[] inputArray){
		int len = inputArray.length;
		if(len == 0)
			throw new AssertionError("Array is empty ");
		
		boolean match = false;
		int count = 0;
		
		for( int iterator = 0; iterator < len-1; iterator++ ){
			if ( !match && inputArray[iterator] == inputArray[iterator + 1] ){
				match = true;
				count++;
			}
			else if( inputArray[iterator] != inputArray[iterator+1]){
				match = false;
			}
		}
		return count;
	}
	
	/**
	 * Fix XY.
	 *
	 * @param inputArray represents the input array
	 * @param X represents the value of X
	 * @param Y represents the value of Y
	 * @return the rearranged array 
	 */
	public static int[] fixXY(int[] inputArray, int X, int Y){
		
		int len = inputArray.length;
		if(len == 0 )
			throw new AssertionError("Array is empty");
		if( inputArray[len - 1 ] == X)
			throw new AssertionError(X + " can't occur at last of array");
		
		ArrayList<Integer> locationX = new ArrayList<Integer>();
		ArrayList<Integer> locationY = new ArrayList<Integer>();
		int countX = 0, countY = 0;
		for( int iterator =0; iterator < len; iterator++){
		
			if( inputArray[ iterator ] == X){
				
				if(inputArray[iterator + 1]==X)
					throw new AssertionError(" Adjacent values of "+ X + " is not allowed");
				locationX.add(iterator);
				countX++;
			}
			
			if( inputArray[ iterator ] == Y){
				locationY.add(iterator);
				countY++;
			}
		}
		if(countX != countY)
			throw new AssertionError("X and Y are not in equal number");
		
		//Main Logic 
		int lenX =  locationX.size();
		
		for( int iterator = 0; iterator < lenX ; iterator++ ){
			int swapVar = inputArray[locationX.get(iterator)+1];
			inputArray[locationX.get(iterator)+1] = inputArray[locationY.get(iterator)];
			inputArray[locationY.get(iterator)] = swapVar;
			
		}
		return inputArray;
	}
	
	/**
	 * Split array.
	 *
	 * @param inputArray represents the input array
	 * @return represents the index if there is a place to split 
	 */
	public static int splitArray( int[] inputArray){
		
		int len = inputArray.length;
		if( len == 0 )
			throw new AssertionError("Array is empty");
		
		int leftSideSum=0,rightSideSum=0;
		for( int iterator =0 ; iterator < len; iterator++){
			leftSideSum += inputArray[iterator];
		}
		for( int iterator = len-1 ; iterator >= 0; iterator--){
			rightSideSum += inputArray[iterator];
			
	        leftSideSum -=  inputArray[iterator] ; 
	        
	        if (rightSideSum == leftSideSum) 
	            return iterator ; 

		}
		return -1;
		
		
	}
}
	