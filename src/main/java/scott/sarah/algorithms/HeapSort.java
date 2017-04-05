package scott.sarah.algorithms;

public class HeapSort implements Sort {
	
	int[] array;
	
	public HeapSort(){
	}
	
	public HeapSort(int[] array){
		setArray(array);
	}
	
	public void setArray(int[] array){
		this.array = array;
	}
	
	public int[] sort() {
		int n = array.length;
		
		for(int i = n/2-1; i >=0; i--){
			createHeap(n, i);
		}
		
		for(int i = n-1; i>=0; i--){
			swap(0, i);		
			createHeap(i, 0);
		}
		
		return array;
	}
	
	private void createHeap(int n, int i){
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < n && array[left] > array[largest]){
			largest = left;
		}
		
		if(right < n && array[right] > array[largest]){
			largest = right;
		}
		
		if(largest != i){
			swap(i, largest);			
			createHeap(n, largest);
		}	
	}
	
	void swap(int low, int high){
		int temp = array[low];
		array[low] = array[high];
		array[high] = temp;
			
	}

}
