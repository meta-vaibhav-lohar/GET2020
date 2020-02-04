
/**
 * The Class Search.
 */
public class Search {

	/**
	 * Linear search.
	 *
	 * @param inputArray the input array
	 * @param element the element
	 * @param leftIterator the left iterator
	 * @param rightIterator the right iterator
	 * @return the index of element if found, otherwise -1
	 */
	public static int linearSearch(int[] inputArray, int element, int leftIterator, int rightIterator) {
		
		if( rightIterator < leftIterator)
			return -1;
		if( inputArray[leftIterator] == element)
			return leftIterator;
		if( inputArray[rightIterator] == element)
			return rightIterator;
		
		return linearSearch(inputArray, element, leftIterator + 1, rightIterator - 1);
		
	}
	
	/**
	 * Linear search call.
	 *
	 * @param inputArray the input array
	 * @param element the element
	 * @return the index
	 */
	public static int linearSearchCall(int[]  inputArray, int element){
		return linearSearch(inputArray, element, 0, inputArray.length-1);
	}
	/**
	 * Binary search.
	 *
	 * @param inputArray the input array
	 * @param element the element
	 * @param start the start of array
	 * @param end the end of array
	 * @return the index of the element if found, otherwise -1
	 */
	public static int binarySearch( int[] inputArray, int element, int start, int end){
		
		if(end >= start){
			int mid = (start+ end)/2;
			
			if(inputArray[mid] == element)
				return mid;
			if(inputArray[mid] < element)
				return binarySearch(inputArray, element, start, mid-1);
		
			return binarySearch(inputArray, element, mid+1, end);
		}
		return -1;
	}
	
	/**
	 * Binary search call.
	 *
	 * @param inputArray the input array
	 * @param element the element
	 * @return the int
	 */
	public static int binarySearchCall(int[]  inputArray, int element){
		return binarySearch(inputArray, element, 0, inputArray.length-1);
	}
}
