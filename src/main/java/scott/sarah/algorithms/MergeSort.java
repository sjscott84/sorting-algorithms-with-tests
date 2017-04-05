package scott.sarah.algorithms;

public class MergeSort implements Sort {
	
	private int[] array;
	private int[] tempArray;
	
	public MergeSort(int[] array){
		setArray(array);
	}
	
	public MergeSort(){
		
	}
	
	public void setArray(int[] array){
		this.array = array;
		this.tempArray = new int[array.length];
	}
	
	public int[] sort(){
		mergeSort(0, array.length-1);
		return array;
	}
	
	private void mergeSort(int lowIndex, int highIndex){
		if(lowIndex < highIndex){
			int middle = lowIndex + (highIndex - lowIndex)/2;
			mergeSort(lowIndex, middle);
			mergeSort(middle+1, highIndex);
			mergeParts(lowIndex, middle, highIndex);
		}	
	}
	
	void mergeParts(int low, int middle, int high){
        for (int i = low; i <= high; i++) {
           this.tempArray[i] = this.array[i];
        }
		int i = low;
		int j = middle + 1;
		int k = low;
		while(i <= middle && j <= high){
			if(this.tempArray[i] <= this.tempArray[j]){
				this.array[k] = this.tempArray[i];
				i++;
			}else{
				this.array[k] = this.tempArray[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			this.array[k] = this.tempArray[i];
			k++;
			i++;
		}	
	}
}
