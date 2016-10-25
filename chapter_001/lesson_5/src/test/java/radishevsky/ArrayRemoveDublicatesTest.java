package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class ArrayRemoveDublicatesTest
  * @author vladradishevsky
  * @since 25.10.2016
  * @version 1.0
**/
public class ArrayRemoveDublicatesTest {
	
	@Test
	public void whenArrayIsOneStringThenReturnItSelf()
	{
		ArrayRemoveDublicates array = new ArrayRemoveDublicates(new String[]{"One"});
		array.removeAllDublicatesInArray();
		
		assertEquals(array.values, new String[]{"One"});
	}
	
	@Test
	public void whenArrayNeedToSortingThenReturnSortedArray()
	{
		ArrayRemoveDublicates array = new ArrayRemoveDublicates(new String[]{"0","1","2","3","0","1","2","3","0","0","4","6","6","5"});
		array.removeAllDublicatesInArray();
		
		assertEquals(array.values, new String[]{"0","1","2","3","4","6","5"});
	}
}