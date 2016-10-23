package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class ArraySortTest
  * @author vladradishevsky
  * @since 23.10.2016
  * @version 1.0
**/
public class ArraySortTest {

	@Test
	public void whenArrayIsOneCellThenReturnItSelf() {
		ArraySort array = new ArraySort(new int[]{1});
		array.BubbleSort();
		
		assertThat(array.getValues(), is(new int[]{1}));
	}

	@Test
	public void whenArrayIsSortedThenReturnItSelf() {
		ArraySort array = new ArraySort(new int[]{1, 2, 3, 4, 5});
		array.BubbleSort();
		
		assertThat(array.getValues(), is(new int[]{1, 2, 3, 4, 5}));
	}
	
}