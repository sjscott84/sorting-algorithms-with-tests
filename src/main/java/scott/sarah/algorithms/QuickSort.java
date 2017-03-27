package scott.sarah.algorithms;

public class QuickSort {
	
	int [] array;
	public QuickSort(int[] array) {
		this.array = array;
	}

	//Quick Sort Methods (4 in total including a helper method swap)
	public int[] quickSortSetup(int[] arrayToSort){
		array = arrayToSort;
		quickSort(0, arrayToSort.length - 1);
		return array;
	}
	
	private void quickSort(int lowIndex, int highIndex){
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

	void swap(int first, int second){
		int temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}

}
