package scott.sarah.algorithms;

public class RandomQuickSort implements Sort {
	
	int[] array;
	
	public RandomQuickSort(){
		
	}
	
	public RandomQuickSort(int[] array) {
		setArray(array);
	}
	
	public void setArray(int[] array){
		this.array = array;
	}
	
	public int[] sort(){
		quickSort(0, array.length - 1);
		return array;
	}
	
	public void quickSort(int lowIndex, int highIndex){
		if(lowIndex < highIndex){
			int pivot = partition(lowIndex, highIndex);
			quickSort(lowIndex, pivot - 1);
			quickSort(pivot + 1, highIndex);
		}
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
	
	void swap(int first, int second){
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

}
