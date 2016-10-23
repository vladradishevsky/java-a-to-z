package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class ArraySortTest
  * @author vladradishevsky
  * @since 23.10.2016
  * @version 1.0 fix2
**/
public class ArraySortTest {

	@Test
	public void whenArrayIsOneCellThenReturnItSelf() {
		ArraySort array = new ArraySort(new int[]{1});
		array.bubbleSort();
		
		assertThat(array.getValues(), is(new int[]{1}));
	}

	@Test
	public void whenArrayIsSortedThenReturnItSelf() {
		ArraySort array = new ArraySort(new int[]{1, 2, 3, 4, 5});
		array.bubbleSort();
		
		assertThat(array.getValues(), is(new int[]{1, 2, 3, 4, 5}));
	}

	@Test
	public void whenArrayIsNotSortedThenReturnSorted() {
		ArraySort array = new ArraySort(new int[]{3, 1, 2, 5, 4, 10, 9, 8, 7, 6});
		array.bubbleSort();
		
		assertThat(array.getValues(), is(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
	
}