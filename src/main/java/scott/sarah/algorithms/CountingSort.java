package scott.sarah.algorithms;

public class CountingSort  {
	
	int[] array;
	int[] countArray;
	int[] resultArray;
	
	public CountingSort(){	
	}
	
	public CountingSort(int[] array, int highNumber){
		setArray(array, highNumber);
	}
	
	public void setArray(int[] array, int highNumber){
		this.array = array;
		this.countArray = new int[highNumber + 1];
		this.resultArray = new int[array.length];
	}

	public int[] sort (){
		countArray = addZeroToCountArray(countArray);
		
		countArray = countHowManyValuesInArray(countArray);
		
		countArray = countAllValuesTogether(countArray);

		for(int i = 0; i < array.length; i++){
			resultArray[countArray[array[i]]-1] = array[i];
			countArray[array[i]]--;
		}
		
		return resultArray;
	}
	
	/**
	 * Ensures all elements in countArray are zero
	 * @param zeroArray
	 * @return
	 */
	int[] addZeroToCountArray(int[] zeroArray){
		for (int i=0; i<array.length; i++){
            zeroArray[i] = 0;
		}
		
		return zeroArray;
	}
	
	/**
	 * Counts how many times a value appears in the array to sort
	 * and adds this count to countArray (e.g. array to sort is {3,1,3}
	 * countArray would be {0,1,0,2}
	 * @param arrayToCount
	 * @return
	 */
	int[] countHowManyValuesInArray(int[] arrayToCount){
		for (int i = 0; i < array.length; i++){
			int x = arrayToCount[array[i]];
			x++;
			arrayToCount[array[i]] = x;
		}
		return arrayToCount;
	}
	
	/**
	 * Adds up countArray(e.g. if countArray is {0,1,0,2} as above this method
	 * would transform countArray to {0,1,1,3}
	 * @param arrayToCount
	 * @return
	 */
	int[] countAllValuesTogether(int[] arrayToCount){
		for(int i = 1; i < arrayToCount.length; i++){
			arrayToCount[i] = arrayToCount[i] + arrayToCount[i-1];
		}
		return arrayToCount;
	}

}
