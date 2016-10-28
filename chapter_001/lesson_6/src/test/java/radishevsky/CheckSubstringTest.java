package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class CheckSubstringTest
  * @author vladradishevsky
  * @since 28.10.2016
  * @version 1.0
**/
public class CheckSubstringTest {
	
	@Test
	public void whenSubstringInTheBeginThenReturnTrue()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345678910", "012"), is(true));
	}
	
	@Test
	public void whenSubstringInTheEndThenReturnTrue()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345678910", "910"), is(true));
	}	
	
	@Test
	public void whenSubstringInTheMiddleThenReturnTrue()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345678910", "456"), is(true));
	}
	
	@Test
	public void whenSubstringIsEmptyThenReturnFalse()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345678910", ""), is(true));
	}

	@Test
	public void whenSubstringIsOneSymbolInTheBeginThenReturnTrue()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345678910", "0"), is(true));
	}
	
	@Test
	public void whenSubstringIsOriginStringThenReturnTrue()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345678910абвг", "012345678910абвг"), is(true));
	}
	
	@Test
	public void whenSubstringIsLargerThenReturnFalse()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345678910", "0123456789101"), is(false));
	}
	
	@Test
	public void whenSubstringDontContainsThenReturnFalse()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("012345", "456"), is(false));
	}
	
	@Test
	public void whenSubstringContains2TimesThenReturnTrue()
	{
		CheckSubstring chcksbstr = new CheckSubstring();
		assertThat(chcksbstr.contains("01234567890123456789", "456"), is(true));
	}
}