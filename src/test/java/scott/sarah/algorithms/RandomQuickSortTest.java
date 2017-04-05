package scott.sarah.algorithms;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.Matchers.isOneOf;


import org.junit.Test;

public class RandomQuickSortTest {
	
	@Test
	public void swapShouldSwapTwoIndexes() {
		int[] array = {1, 0};
		RandomQuickSort randomQuickSort = new RandomQuickSort(array);
		
		randomQuickSort.swap(0, 1);
		
		assertThat(array[0], is(0));
	}

	@Test
	public void partitionShouldReturnAnyElementInArray() {
		int[] array = {1, 0, 2};
		RandomQuickSort randomQuickSort = new RandomQuickSort(array);
		
		int pivot = randomQuickSort.partition(0,2);
		
		assertThat(pivot, isOneOf(0,1,2));
	}
	
	@Test
	public void sortShouldReturnArraySortedNumerically() {
		int[] array = {3,1,2, -10, 5, -2};
		int[] expectedArray = {-10, -2, 1,2,3, 5};
		RandomQuickSort randomQuickSort = new RandomQuickSort(array);
		
		int[] sortedArray = randomQuickSort.sort();
		
		assertArrayEquals(sortedArray, expectedArray);

	}

}
