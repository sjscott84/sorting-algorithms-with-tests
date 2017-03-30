package scott.sarah.algorithms;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class InsertionSortTest {
	
	@Test
	public void swapShouldSwapTwoIndexes() {
		int[] array = {1, 0};
		InsertionSort insertionSort = new InsertionSort(array);
		
		insertionSort.swap(1);
		
		assertThat(array[0], is(0));
	}
	
	@Test
	public void currentShouldBeReducedByOne(){
		int[] array = {1,0};
		InsertionSort insertionSort = new InsertionSort(array);
		
		int checkCurrent = insertionSort.changeCurrent(2);
		
		assertThat(checkCurrent, is(1));
	}
	
	@Test
	public void arrayShouldBeSortedNumerically(){
		int[] array = {1,0,-2,3};
		int[] expectedArray = {-2,0,1,3};
		InsertionSort insertionSort = new InsertionSort(array);
		
		int[] sortedArray = insertionSort.sort();
		
		assertArrayEquals(sortedArray, expectedArray);
	}
}
