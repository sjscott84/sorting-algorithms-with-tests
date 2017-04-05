package scott.sarah.algorithms;

public class SelectionSort implements Sort {
	
	int[] array;
	
	public SelectionSort(){
		
	}
	
	public SelectionSort(int[] array) {
		setArray(array);
	}
	
	public void setArray(int[] array){
		this.array = array;
	}
	/**
	 * Selection sort algorithm
	 * @return
	 */
	public int[] sort(){
		for(int i = 0; i < array.length; i++){
			int smallestIndex = i;
			for(int j = i+1; j < array.length; j++){
				if(array[j] < array[smallestIndex]){
					smallestIndex = j;
				}
			}
			swap(i, smallestIndex);
		}
		return array;
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
