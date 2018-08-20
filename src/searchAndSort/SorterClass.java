package searchAndSort;
import java.util.Arrays;

public abstract class SorterClass {
	
	protected int comps;
	protected int swaps;
	protected String sortName;
	
	public SorterClass(String sortName) {
		comps = 0;
		swaps = 0;
		this.sortName = sortName;
	}

	/**
	 * Returns an array of ints as a string
	 * @param numbers  array
	 * @return the array as a string
	 */
	public static String toString(int[] numbers) {
		String output = "";
		for(int x=0;x<numbers.length;x++){
			output = output + numbers[x] + " ";
		}
		return output;
	}
	
	/**
	 * Builds an unsorted array of random integers
	 * @param length  length of the array to be built
	 * @param lowerBound  lower bound of the random numbers
	 * @param upperBound  upper bound of the random numbers
	 * @return  an array
	 */
	public static int[] buildArray(int length, int lowerBound, int upperBound) {
		int[] numbers = new int[length];
		for(int x=0;x<length;x++){
			numbers[x]=(int) ((upperBound-lowerBound+1)*Math.random() + lowerBound);
		}
		return numbers;
	}
	
	/**
	 * Builds a sorted array
	 * @param length  length of the array to be built
	 * @param increasing  whether the array should be in increasing order
	 * @return  an array
	 */
	public static int[] buildArray(int length, boolean increasing) {
		int change=-1;
		int counter=length;
		int[] numbers = new int[length];
		if(increasing){change=1;counter=1;}
		for(int x=0;x<length;x++){
			numbers[x]=counter;
			counter=counter+change;
		}
		return numbers;
	}
	
	
	/**
	 * Public method to sort an array of integers
	 * @param numbers integer array to sort
	 * @param increasing whether to sort increasing or decreasing order
	 * @return the array in increasing or decreasing order
	 */
	public final int[] sort(int[] numbers, boolean increasing) {
		swaps = 0; comps = 0;
		return sortArray(numbers, increasing);
	}
	
	/**
	 * Sorts the array in place and returns it. This is the method to override when creating new sorts
	 * @param numbers  array to be sorted
	 * @param increasing  whether the sort should be in increasing order
	 * @return
	 */
	int[] sortArray(int[] numbers, boolean increasing) {
		return numbers;
	}
	
	/**
	 * Tests the sort on a number of different input types
	 * @param length length of the arrays to test the sort with
	 * @param output if true, include the array values in the string
	 * @return an output string with results of the test (comparisons and swaps)
	 */
	public String testSort(int length, boolean output) {
		String outString = "Testing "+sortName+" on Arrays of Length "+length;
		int[] testArray = buildArray(length,0,10);
		int[] sortedArray = sort(Arrays.copyOf(testArray,testArray.length),true);
		outString+="\nRandom: \n  Comparisons: " + comps + " | Swaps: " + swaps;
		if(output) {outString+="\n  Unsorted Array: " + toString(testArray) + "\n    Sorted Array: " + toString(sortedArray);}
		testArray = buildArray(length,true);
		sortedArray = sort(Arrays.copyOf(testArray,testArray.length),true);
		outString+="\nAscending: \n  Comparisons: " + comps + " | Swaps: " + swaps;
		if(output) {outString+="\n  Unsorted Array: " + toString(testArray) + "\n    Sorted Array: " + toString(sortedArray);}
		testArray = buildArray(length,false);
		sortedArray = sort(Arrays.copyOf(testArray,testArray.length),true);
		outString+="\nDescending: \n  Comparisons: " + comps + " | Swaps: " + swaps;
		if(output) {outString+="\n  Unsorted Array: " + toString(testArray) + "\n    Sorted Array: " + toString(sortedArray);}
		return outString;
	}
	
	/**
	 * @return amount of comparisons
	 */
	public int getComps() {
		return comps;
	}
	
	/**
	 * @return amount of swaps
	 */
	public int getSwaps() {
		return swaps;
	}
}
