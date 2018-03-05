package searchAndSort;
import java.util.ArrayList;

public class RadixSorter extends SorterClass {
	
	public RadixSorter() {
		comps = 0;
		swaps = 0;
		sortName = "Radix Sort";
	}
	
	/**
	 * @param numbers  Array of Numbers
	 * @param place  The place value that we're sorting by right now
	 * @return  The Arraylist of Arraylists (the buckets)
	 */
	public static ArrayList<ArrayList<Integer>> intoBuckets(int[] numbers, int place) {
		ArrayList<ArrayList<Integer>> buckets = createEmptyBuckets(10);
		int index;
		for (int x=0;x<numbers.length;x++) {
			index = valueAtPlace(numbers[x],place);
			buckets.get(index).add(numbers[x]);
		}
		return buckets;
	}
	
	/**
	 * @param bucketCount  The amount of empty buckets to create
	 * @return An arrayList of emptyArrayLists
	 */
	public static ArrayList<ArrayList<Integer>> createEmptyBuckets(int bucketCount) {
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(0);
		for(int x = 0; x < bucketCount; x++) {
			buckets.add(new ArrayList<Integer>());
		}
		return buckets;
	}
	
	/**
	 * @param buckets  The buckets that numbers have been placed into
	 * @return The amount of elements in all buckets
	 */
	public static int getBucketSize(ArrayList<ArrayList<Integer>> buckets) {
		int counter = 0;
		for(int x=0; x<buckets.size();x++) {
			counter=counter+buckets.get(x).size();
		}
		return counter;
	}
	
	/**
	 * @param buckets  The buckets that the numbers have been placed into
	 * @param increasing  Whether to create an array in ascending or descending order
	 * @return  An array of the numbers in buckets
	 */
	public static int[] intoArray(ArrayList<ArrayList<Integer>> buckets, boolean increasing) {
		int[] numbers = new int[getBucketSize(buckets)];
		int counter = 0;
		if(increasing) {
			for (int x=0; x<buckets.size();x++) {
				for(int y=0;y<buckets.get(x).size();y++) {
					numbers[counter] = buckets.get(x).get(y);
					counter++;
				}
			}
		} else {
			for (int x=buckets.size()-1; x>=0;x--) {
				for(int y=0;y<buckets.get(x).size();y++) {
					numbers[counter] = buckets.get(x).get(y);
					counter++;
				}
			}
		}
		return numbers;
		}
	
	/**
	 * @param inputNumber  the number
	 * @param place  the place value (one's is 1, ten's is 2, )
	 * @return  The digit of inputNumber at place
	 */
	public static int valueAtPlace(int inputNumber, int place) {
		int newNum = (int) Math.floor(inputNumber/Math.pow(10, place-1));
		int outputNum = newNum % 10;
		return outputNum;
	}
	
	@Override
	public int[] sortArray(int[] numbers, boolean increasing) {
		boolean sentinel = true;
		int place = 1;
		ArrayList<ArrayList<Integer>> buckets;
		while(sentinel) {
			buckets = intoBuckets(numbers,place);
			numbers = intoArray(buckets, increasing);
			if(buckets.get(0).size() == getBucketSize(buckets)) {
				sentinel = false;
			}
			place++;
		}
		return numbers;
	}
}