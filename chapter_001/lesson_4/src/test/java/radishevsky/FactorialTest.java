package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.math.BigInteger;

/** 
  * Class FactorialTest
  * @author vladradishevsky
  * @since 22.10.2016
  * @version 1.1
**/
public class FactorialTest {

	@Test
	public void whenParamIsZeroThenReturnZero() {
		Factorial factorial = new Factorial();
		assertEquals(factorial.getFactorial(0), new BigInteger("1"));
	}
	
	@Test
	public void whenParamIsOneThenReturnOne() {
		Factorial factorial = new Factorial();
		assertEquals(factorial.getFactorial(1), new BigInteger("1"));
	}
	
	@Test
	public void whenParamIsTenThenReturnCorrectResult() {
		Factorial factorial = new Factorial();
		assertEquals(factorial.getFactorial(10), new BigInteger("3628800"));
	}
	
	
}