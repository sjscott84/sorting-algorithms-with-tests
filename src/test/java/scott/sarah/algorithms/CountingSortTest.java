package scott.sarah.algorithms;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class CountingSortTest {
	@Test
	public void addZeroToCountArrayShouldMakeAllValuesZero(){
		int[] array = {3,1,2};
		int[] expectedArray = {0,0,0};
		CountingSort countingSort = new CountingSort(array, 3);
		
		int[] countArray = countingSort.addZeroToCountArray(array);
		
		assertArrayEquals(countArray, expectedArray);
	}
	
	@Test
	public void shouldCountHowManyTimesAValueIsInArrayAndUpdateCountArray(){
		int[] array = {3,1,1};
		int[] emptyCountArray = {0,0,0,0};
		int[] expectedArray = {0,2,0,1};
		CountingSort countingSort = new CountingSort(array, 3);
		
		int[] countArray = countingSort.countHowManyValuesInArray(emptyCountArray);
		
		assertArrayEquals(countArray, expectedArray);
	}
	
	@Test
	public void shouldAddUpAllValuesInCountArray(){
		int[] array = {3,1,1};
		int[] inputArray = {0,2,0,1};
		int[] expectedArray = {0,2,2,3};
		CountingSort countingSort = new CountingSort(array, 3);
		
		int[] countArray = countingSort.countAllValuesTogether(inputArray);
		
		assertArrayEquals(countArray, expectedArray);
	}
	
	@Test
	public void countingSortShouldReturnArraySortedNumerically() {
		int[] array = {3,1,2,5};
		int[] expectedArray = {1,2,3,5};
		CountingSort countingSort = new CountingSort(array, 5);
		
		int[] sortedArray = countingSort.sort();
		
		assertArrayEquals(sortedArray, expectedArray);

	}
}
