package scott.sarah.algorithms;

public class InsertionSort {
	
	int[] array;
	
	public InsertionSort(int[] array){
		this.array = array;
	}
	
	int[] sort (){
		int current;
		for(int i = 1; i < array.length; i++){
			current = i;
			while(current > 0 && array[current] < array[current - 1]){
				swap(current);
				current = changeCurrent(current);
			}
		}
		return array;
	}
	
	void swap(int current){
	int temp = array[current];
	array[current] = array[current - 1];
	array[current - 1] = temp;
	}
	
	int changeCurrent(int current){
		return current-1;
	}
}
