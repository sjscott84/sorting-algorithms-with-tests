package scott.sarah.algorithms;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MergeSortTest {
	
	@Test
	public void mergeSortShouldReturnArraySortedNumerically() {
		int[] array = {3,1,2, -10, 5, -2};
		int[] expectedArray = {-10, -2, 1,2,3, 5};
		MergeSort mergeSort = new MergeSort(array);
		
		int[] sortedArray = mergeSort.sort();
		
		assertArrayEquals(sortedArray, expectedArray);

	}

}
