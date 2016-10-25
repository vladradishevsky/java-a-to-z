package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class ArrayRotateTest
  * @author vladradishevsky
  * @since 25.10.2016
  * @version 1.0
**/
public class ArrayRotateTest {

	@Test
	public void whenArrayIsOneCellThenReturnItSelf()
	{
		ArrayRotate array = new ArrayRotate();
		array.rotateArray();
		
		int[][] second_array = new int[1][1];
		second_array[0][0] = 0;
		
		assertThat(array.values, is(second_array));
	}

	@Test
	public void whenArrayIsRotatedThenReturnItSelf()
	{
		int[][] values = {  {1,2,3,4},
							{2,2,2,2},
							{3,2,3,3},
							{4,2,3,4}};
		ArrayRotate array = new ArrayRotate(values);
		array.rotateArray();
		
		assertThat(array.values, is(values));
	}

	@Test
	public void whenArrayIsNotRotatedThenReturnSorted()
	{
		int[][] values = {  {1,1,1,1},
							{2,2,2,2},
							{3,3,3,3},
							{4,4,4,4}};
							
		ArrayRotate array = new ArrayRotate(values);
		array.rotateArray();
		
		int[][] valuesAfterRotate = {{1,2,3,4}, {1,2,3,4}, {1,2,3,4}, {1,2,3,4},};

		assertThat(array.values, is(valuesAfterRotate));
	}
	
}