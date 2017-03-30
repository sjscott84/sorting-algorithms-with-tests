package scott.sarah.algorithms;

public class RandomQuickSort extends QuickSort {
	
	int[] array;
	
	public RandomQuickSort(int[] array) {
		super(array);
		this.array = array;
	}
	
	/**
	 * This partition method picks a random partition (unlike QuickSort which is deterministic)
	 */
	int partition(int lowIndex, int highIndex){
		int p = lowIndex;
		int random = (int )(Math.random() * (highIndex-lowIndex) + lowIndex);
		int pivotValue = array[random];
		swap(random, highIndex);
		for(int i = lowIndex; i < highIndex; i++){
			if(array[i] < pivotValue){
				swap(p, i);
				p++;
			}
		}
		swap(highIndex, p);
		return p;
	}

}
