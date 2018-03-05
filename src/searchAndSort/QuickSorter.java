package searchAndSort;
import java.util.Arrays;

public class QuickSorter extends SorterClass {
	
	public QuickSorter() {
		comps = 0;
		swaps = 0;
	sortName = "Quick Sort";
	}
	
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
	
	public int[] combineArrays(int[] firstArray, int[] secondArray) {
		int[] finalArray = new int[firstArray.length + secondArray.length];
		int counter = 0;
		for(int x=0; x<firstArray.length;x++) {
			finalArray[counter] = firstArray[x];
			counter++;
		}
		for(int x=0; x<secondArray.length;x++) {
			finalArray[counter] = secondArray[x];
			counter++;
		}
		return finalArray;
	}
	
	@Override //this method doesnt work correctly yet
	public int[] sortArray(int[] numbers, boolean increasing) {
		
		int rightIndex = numbers.length-1;
		
		if(numbers.length == 0) {
			return numbers;
		}
		
		int pivot = median3(numbers[(rightIndex+0)/2],numbers[0],numbers[rightIndex]);
		
		int left = 0;
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
		
		if(right < 0 || left > rightIndex) {
			return numbers;
		}
		
		//return combination of quickSort left and quickSort right
		return combineArrays(sortArray(Arrays.copyOfRange(numbers, 0, right), increasing),sortArray(Arrays.copyOfRange(numbers, left, rightIndex), increasing));
	}
}