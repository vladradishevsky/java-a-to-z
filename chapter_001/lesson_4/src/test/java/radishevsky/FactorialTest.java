package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.math.BigInteger;

public class FactorialTest {
	
	Factorial factorial = new Factorial();
	@Test
	public void whenParamIsZeroThenReturnZero() {
		
		assertEquals(factorial.getFactorial(0), new BigInteger("1"));
	}
	
	@Test
	public void whenParamIsOneThenReturnOne() {
		
		assertEquals(factorial.getFactorial(1), new BigInteger("1"));
	}
	
	@Test
	public void whenParamIsTenThenReturnCorrectResult() {
		
		assertEquals(factorial.getFactorial(10), new BigInteger("3628800"));
	}
	
	
}