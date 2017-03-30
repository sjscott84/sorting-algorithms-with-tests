package scott.sarah.algorithms;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HeapSortTest {
	
	@Test
	public void swapShouldSwapTwoIndexes() {
		int[] array = {1, 0};
		HeapSort heapSort = new HeapSort(array);
		
		heapSort.swap(0, 1);
		
		assertThat(array[0], is(0));
	}
	
	@Test
	public void heapSortShouldReturnArraySortedNumerically() {
		int[] array = {3,1,2, -10, 5, -2};
		int[] expectedArray = {-10, -2, 1,2,3, 5};
		HeapSort heapSort = new HeapSort(array);
		
		int[] sortedArray = heapSort.sort();
		
		assertArrayEquals(sortedArray, expectedArray);

	}
}
