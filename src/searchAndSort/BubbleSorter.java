package searchAndSort;

public class BubbleSorter extends SorterClass {
	
	public BubbleSorter() {
		super("Bubble Sort");
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
	 * 
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
	
	@Override
	public int[] sortArray(int[] numbers, boolean increasing) {
		comps=0;
		swaps=0;
		int counter;
		boolean sentinel = true;
		int x;
		while(sentinel) {
		counter=0;
		for(x=0;x<numbers.length-1;x++){
			comps++;
			if(compareTwo(numbers[x],numbers[x+1],increasing)){
				numbers = swapTwo(numbers,x,x+1);
				swaps++;
			}else{counter++;}
		}
		if(counter==x) {
			sentinel=false;
		}
		}
		//problem before this line
		return numbers;
	}
}
