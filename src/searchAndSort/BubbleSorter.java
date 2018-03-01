package searchAndSort;

public class BubbleSorter extends SorterClass {
	
	public BubbleSorter() {
		comps = 0;
		swaps = 0;
		sortName = "Bubble Sort";
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
