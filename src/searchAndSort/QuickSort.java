package searchAndSort;

//previous version

public class QuickSort extends SorterClass {

	public QuickSort() {
		comps = 0;
		swaps = 0;
	sortName = "Quick Sort";
	}
	
		private int[] numContainer;
		private int swaps = 0;
		private int comps = 0;
		public QuickSort(int lenner) {
			numContainer= new int[lenner];
		}
		
		public void setnumContainerRandom(int bottom, int top) {
			for(int x=0;x<numContainer.length;x++){
				numContainer[x]=(int) ((top-bottom+1)*Math.random() + bottom);
			}
		}
		
		public String toString() {
			String output = "";
			for(int x=0;x<numContainer.length;x++){
				output = output + numContainer[x] + " ";
			}
			return output;
		}
		
		public void buildArray(boolean increasing) {
			comps=0;swaps=0;
			int change=-1;
			int counter=numContainer.length;
			if(increasing){change=1;counter=1;}
			for(int x=0;x<numContainer.length;x++){
				numContainer[x]=counter;
				counter=counter+change;
			}
		}

		public int length() {
			return numContainer.length;
		}
		
		public String getCompsAndSwaps() {
			return "Comparisons: " + comps + " Swaps: " + swaps;
		}
		
		public void rebuild(int length, boolean random, boolean increasing) {
			comps=0;swaps=0;
			numContainer = new int[length];
			if(random) {
			setnumContainerRandom(1,length);
			}else {buildArray(increasing);}	
		}
		
		public int median3(int a, int b, int c) {
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
		
		public void quickSort(int leftIndex, int rightIndex) {
			
			if(leftIndex>=rightIndex) {
				return;
			}
			
			int pivot = median3(numContainer[(rightIndex+leftIndex)/2],numContainer[leftIndex],numContainer[rightIndex]);
			
			int left = leftIndex;
			int right = rightIndex;
			boolean sentinel = true;
			while(sentinel) {
				if(numContainer[left]<pivot) {
					comps++;
					left++;
				} else if(numContainer[right]>pivot) {
					comps++;
					right--;
				} else {
					comps++;
					swaps++;
					int swapper = numContainer[left];
					numContainer[left]=numContainer[right];
					numContainer[right]=swapper;
				}
				
				if(numContainer[left]==pivot && numContainer[right]==pivot){
					left++;
					right--;
				}
				
				if(left>=right){
					sentinel=false;
				}
			}
			
			quickSort(leftIndex, right);
			quickSort(left,rightIndex);
		}

}