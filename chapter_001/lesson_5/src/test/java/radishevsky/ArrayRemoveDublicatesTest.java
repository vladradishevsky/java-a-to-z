package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class ArrayRemoveDublicatesTest
  * @author vladradishevsky
  * @since 25.10.2016
  * @version 1.1
**/
public class ArrayRemoveDublicatesTest {
	
	@Test
	public void whenArrayIsOneStringThenReturnItSelf()
	{
		ArrayRemoveDublicates array = new ArrayRemoveDublicates(new String[]{"One"});
		array.removeAllDublicatesInArray();
		
		assertThat(array.values, is(new String[]{"One"}));
	}
	
	@Test
	public void whenArrayNeedToSortingThenReturnSortedArray()
	{
		ArrayRemoveDublicates array = new ArrayRemoveDublicates(new String[]{"0","1","2","3","0","1","2","3","0","0","4","6","6","5"});
		array.removeAllDublicatesInArray();
		
		assertThat(array.values, is(new String[]{"0","1","2","3","4","6","5"}));
	}
}