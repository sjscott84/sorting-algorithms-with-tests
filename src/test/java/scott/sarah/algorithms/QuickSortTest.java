package scott.sarah.algorithms;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void swapShouldSwapTwoIndexes() {
		int[] array = {1, 0};
		QuickSort quickSort = new QuickSort(array);
		
		quickSort.swap(0, 1);
		
		assertThat(array[0], is(0));
	}

	@Test
	public void partitionShouldSwapHighIndexWithLowIndexWhenLastElementIsLowestInArray() {
		int[] array = {1, 0};
		QuickSort quickSort = new QuickSort(array);
		
		int pivot = quickSort.partition(0,1);
		
		assertThat(pivot, is(0));
		assertThat(array[0], is(0));
	}
	
	@Test
	public void pivotShouldIncreaseWhenLowIndexLessThenHighIndexInPartition() {
		int[] array = {0,1};
		QuickSort quickSort = new QuickSort(array);
		
		int pivot = quickSort.partition(0, 1);
		
		assertThat(pivot, is(1));

	}
	
	@Test
	public void returnedArrayShouldBeSortedNumerically() {
		int[] array = {3,1,2};
		QuickSort quickSort = new QuickSort(array);
		int[] expectedArray = {1,2,3};
		
		int[] sortedArray = quickSort.quickSortSetup(array);
		
		assertArrayEquals(sortedArray, expectedArray);

	}
}
