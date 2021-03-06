package scott.sarah.algorithms;

public class QuickSort implements Sort {
	
	private int [] array;
	
	public QuickSort(){
		
	}
	
	public QuickSort(int[] array) {
		setArray(array);
	}
	
	public void setArray(int[] array){
		this.array = array;
	}

	public int[] sort(){
		quickSort(0, array.length - 1);
		return array;
	}
	
	/**
	 * Recursively finds pivot point to call swap function on 
	 * @param lowIndex
	 * @param highIndex
	 */
	public void quickSort(int lowIndex, int highIndex){
		if(lowIndex < highIndex){
			int pivot = partition(lowIndex, highIndex);
			quickSort(lowIndex, pivot - 1);
			quickSort(pivot + 1, highIndex);
		}
	}
	
	/**
	 * Reorders array so that all elements with values greater then the pivot
	 * come after the pivot and visa versa
	 * @param lowIndex
	 * @param highIndex
	 * @return
	 */
	int partition(int lowIndex, int highIndex){
		int pivot = lowIndex;
		for(int i = lowIndex; i < highIndex; i++){
			if(this.array[i] < this.array[highIndex]){
				swap(pivot, i);
				pivot++;
			}
		}
		swap(pivot, highIndex);
		return pivot;
	}
	
	/**
	 * Swaps two elements in array
	 * @param first
	 * @param second
	 */
	void swap(int first, int second){
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

}
