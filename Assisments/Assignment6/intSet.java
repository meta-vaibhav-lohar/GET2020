import java.util.Arrays;

public final class intSet {
	private final int[] setArray;
	private int[] universalArray;

	public intSet(int[] setArray) {

		this.setArray = setArray;
		validate();

	}

	/**
	 * to check errors
	 */
	private void validate() {
		if (setArray.length == 0) {
			throw new AssertionError("Set Empty");
		}
		if (!checkRangeOfSetArray()) {
			throw new AssertionError("elements are not in range");
		}
		boolean[] markEnteredValues = new boolean[1001];

		// checks repeated elements exist or not
		for (int iterator = 0; iterator < setArray.length; iterator++) {
			if (markEnteredValues[setArray[iterator]]) {
				throw new AssertionError("repeated Elements Are Not Allowed");
			} else {
				markEnteredValues[setArray[iterator]] = true;
			}
		}

	}

	/**
	 * checks that does given set contain x or not
	 * 
	 * @param element
	 *            always integer and between 1 to 1000
	 * @return true if element is present in set otherwise false
	 */
	public boolean isMember(int element) {
		int len = size();
		for (int iterator = 0; iterator < len; iterator++) {
			if (setArray[iterator] == element) {
				return true;
			}
		}
		return false;
	}

	/**
	 * size of set
	 * 
	 * @return always return non zero value
	 */
	public int size() {
		return setArray.length;
	}

	/**
	 * checks that whether the given set is a subset of existing set or not
	 * 
	 * @param IntSet
	 *            type set
	 * @return true if s is a subset o existing set otherwise false
	 */
	public boolean isSubSet(intSet s) {
		int setArrayMarker = 0;
		int len = s.size();
		boolean flag = false;
		for( int iterator = 0;iterator < len; iterator++)
			if(isMember(s.setArray[iterator]))
				flag=true;
			else
				return false;
			
		
		return flag;
	}

	/**
	 * checks that does all elements of set are in specified range or not
	 * 
	 * @return true if all elements are in specified range otherwise false
	 */
	private boolean checkRangeOfSetArray() {
		int len = size();
		for (int iterator = 0; iterator < len; iterator++) {
			if (setArray[iterator] < 1 || setArray[iterator] > 1000) {
				return false;
			}
		}
		return true;
	}

	/**
	 * initializes universal array
	 */
	private void initializeUniversalArray() {
		universalArray = new int[1000];
		for (int iterator = 0; iterator < 1000; iterator++) {
			universalArray[iterator] = iterator + 1;
		}
	}

	/**
	 * compliment of existing set
	 * 
	 * @return complimented set
	 */
	public intSet compliment() {
	
		int iterator2 = 0;
		initializeUniversalArray();
		int[] complimentedArray = new int[universalArray.length];
		for (int iterator = 0; iterator < 1000; iterator++) {
			if (!(isMember(iterator + 1))) {
				complimentedArray[iterator2] = iterator + 1;
				iterator2++;
			}
		}
		int[] compliment = new int[iterator2];
		for (int iterator = 0; iterator < compliment.length; iterator++) {
			compliment[iterator] = complimentedArray[iterator];
		}

		intSet intset = new intSet(compliment);
		return intset;
	}

	/**
	 * union two sets such that set contains all elements of set1 and set2
	 * 
	 * @param set
	 *            should in range from 1-1000
	 * @return set
	 */
	public intSet union(intSet set) {
		int setLength = 0;
		int len = size();
		int[] temporaryArray = new int[len + set.size()];
		for (int iterator = 0; iterator < size(); iterator++) {
			temporaryArray[setLength] = setArray[iterator];
			setLength++;
		}
		for (int iterator = 0; iterator < set.size(); iterator++) {
			if (!isMember(set.setArray[iterator])) {
				temporaryArray[setLength] = set.setArray[iterator];
				setLength++;
			}
		}
		System.out.println(Arrays.toString(temporaryArray));
		int[] setArray = new int[setLength];
		for (int iterator = 0; iterator< setLength; iterator++) {
			setArray[iterator] = temporaryArray[iterator];
		}
		return new intSet(setArray);
	}

	/**
	 * @return set of array
	 */
	public int[] getSetArray() {
		int[] setArray = new int[this.setArray.length];
		for (int iterator = 0; iterator < setArray.length; iterator++) {
			setArray[iterator] = this.setArray[iterator];
		}
		return setArray;
	}
	

}