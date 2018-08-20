package searchAndSort;

public class QuickSorter extends SorterClass {
	
	public QuickSorter() {
		super("Quick Sort");
	}
	
	/**
	 * Gets the median of 3 integers
	 * @return the median of a, b, and c
	 */
	public static int median3(int a, int b, int c) {
		if(a>b && a>c) {
			if(b>c) {
				return b;
			}else {
				return c;
			}
		} else if (b>c) {
			if(a>c){
				return a;
			}else{
				return c;
			}
		} else {
			if(b>a){
				return b;
			} else {return a;}
		}
	}
	
	@Override
	public int[] sortArray(int[] numbers, boolean increasing) {
		return quickSort(numbers, 0,numbers.length-1);
	}
	
	/**
	 * Recursive quickSort implementation, going from outside in
	 * @param numbers array of values to sort in place
	 * @param leftIndex left bound of current recursive call
	 * @param rightIndex right bound of current recursive call
	 * @return the sorted array
	 */
	public int[] quickSort(int[] numbers, int leftIndex, int rightIndex) {
		
		if(leftIndex>=rightIndex) {
			return numbers;
		}
		
		int pivot = median3(numbers[(rightIndex+leftIndex)/2],numbers[leftIndex],numbers[rightIndex]);
		
		int left = leftIndex;
		int right = rightIndex;
		boolean sentinel = true;
		while(sentinel) {
			if(numbers[left]<pivot) {
				comps++;
				left++;
			} else if(numbers[right]>pivot) {
				comps++;
				right--;
			} else {
				comps++;
				swaps++;
				int swapper = numbers[left];
				numbers[left]=numbers[right];
				numbers[right]=swapper;
			}
			
			if(numbers[left]==pivot && numbers[right]==pivot){
				left++;
				right--;
			}
			
			if(left>=right){
				sentinel=false;
			}
		}
		
		quickSort(numbers,leftIndex, right);
		return quickSort(numbers,left,rightIndex);
	}
}