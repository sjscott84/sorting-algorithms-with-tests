package scott.sarah.algorithms;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class SelectionSortTest {
	
	@Test
	public void returnedArrayShouldBeInNumericallyInOrder() {
		int[] array = {3,1,2};
		SelectionSort selectionSort = new SelectionSort(array);
		int[] expectedArray = {1,2,3};
		
		int[] sortedArray = selectionSort.selectionSort();
		
		assertArrayEquals(sortedArray, expectedArray);
	}
	
	@Test
	public void swapShouldSwapTwoIndexes() {
		int[] array = {1, 0};
		QuickSort quickSort = new QuickSort(array);
		
		quickSort.swap(0, 1);
		
		assertThat(array[0], is(0));
	}

}
