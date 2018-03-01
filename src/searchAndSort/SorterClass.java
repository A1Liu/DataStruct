package searchAndSort;
import java.util.Arrays;

public abstract class SorterClass {
	
	protected int comps;
	protected int swaps;
	protected String sortName;
	
	public SorterClass() {
		comps = 0;
		swaps = 0;
		sortName = "Default";
	}
	
	/**
	 * @param numberList. The list that needs to get swapped.
	 * @param firstIndex. The index of first number that needs to get swapped.
	 * @param secondIndex. The index of second number that needs to be swapped.
	 * @return The list after the swapping.
	 */
	public static int[] swapTwo(int[] numberList,int firstIndex, int secondIndex) {
			int temp = numberList[firstIndex];
			numberList[firstIndex] = numberList[secondIndex];
			numberList[secondIndex] = temp;
			return numberList;	
		}
	
	/**
	 * @param firstNum First number to be compared
	 * @param secondNum Second number to be compared
	 * @param biggerThan Whether we wanna know if the first number is bigger or less than the second
	 * @return true if first is bigger, false if lesser. If biggerThan is false, then true if lesser, false if bigger.
	 */
	public static boolean compareTwo(int firstNum, int secondNum, boolean biggerThan) {
		if(firstNum > secondNum) {
			return biggerThan;
		} else {return !biggerThan;}
	}
	
	/**
	 * @param firstNum First number to be compared
	 * @param secondNum Second number to be compared
	 * @return true if first is bigger, false if first is lesser.
	 */
	public static boolean compareTwo(int firstNum, int secondNum) {
		if(firstNum > secondNum) {
			return true;
		} else {return false;}
	}
	
	/**
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
	 * @return amount of comparisons
	 */
	public int getComps() {
		return comps;
	}
	
	/**
	 * @return amount of swaps
	 */
	public int getSwaps( ) {
		return swaps;
	}
	
	/**
	 * @param numbers  array to be sorted
	 * @param increasing  whether the sort should be in increasing order
	 * @return
	 */
	public int[] sortArray(int[] numbers, boolean increasing) {
		return numbers;
	}
	
	/**
	 * @param length  length of the test array
	 * @param incInput  whether the test array should be increasing
	 * @param incOutput  whether the test sort should be increasing
	 * @param output  whether the test should output the raw arrays before and after sorting
	 * @return the output string of the test
	 */
	public String testSort(int length, boolean incInput, boolean incOutput, boolean output) {
		int[] numbers = buildArray(length, incInput);
		int[] numbersSorted = sortArray(Arrays.copyOf(numbers,numbers.length), incOutput);
		String information = sortName + ", Array Length: " + length + "\nComparisons: " + comps + " | Swaps: " + swaps;
		if(output) {
			return information + "\nUnsorted Array: " + toString(numbers) + "\n  Sorted Array: " + toString(numbersSorted);
		} else return information;
	}
	
	/**
	 * @param length  length of the test array
	 * @param lowerBound  lower bound for random numbers
	 * @param upperBound  upper bound for random numbers
	 * @param incOutput  whether the test sort should be increasing
	 * @param output  whether the test should output the raw arrays before and after sorting
	 * @return the output string of the test
	 */
	public String testSort(int length, int lowerBound, int upperBound, boolean incOutput, boolean output) {
		int[] numbers = buildArray(length, lowerBound, upperBound);
		int[] numbersSorted = sortArray(Arrays.copyOf(numbers,numbers.length), incOutput);
		String information = sortName + ", Array Length: " + length + "\nComparisons: " + comps + " | Swaps: " + swaps;
		if(output) {
			return information + "\nUnsorted Array: " + toString(numbers) + "\n  Sorted Array: " + toString(numbersSorted);
		} else return information;
	}
}
