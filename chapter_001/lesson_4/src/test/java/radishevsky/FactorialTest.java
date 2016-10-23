package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class FactorialTest
  * @author vladradishevsky
  * @since 23.10.2016
  * @version 1.2
**/
public class FactorialTest {

	@Test
	public void whenParamIsNegativeThenReturnZero() {
		Factorial factorial = new Factorial();
		assertThat(factorial.getFactorial(-1), is(0));
	}

	@Test
	public void whenParamIsZeroThenReturnOne() {
		Factorial factorial = new Factorial();
		assertThat(factorial.getFactorial(0), is(1));
	}
	
	@Test
	public void whenParamIsOneThenReturnOne() {
		Factorial factorial = new Factorial();
		assertThat(factorial.getFactorial(1), is(1));
	}
	
	@Test
	public void whenParamIsTenThenReturnCorrectResult() {
		Factorial factorial = new Factorial();
		assertThat(factorial.getFactorial(10), is(3628800));
	}
	
	
}