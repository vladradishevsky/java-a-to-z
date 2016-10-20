package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {

	Calculator calc = new Calculator();
	
	@Test
	public void whenAddTwoDoublesThenReturnCorrectResult() {
		calc.add(5.5, 6.5);
		assertThat(calc.getResult(), is(12.));
	}
	@Test
	public void whenSubtractTwoDoublesThenReturnCorrectResult() {
		calc.subtract(10, 5.);
		assertThat(calc.getResult(), is(5.));
	}
	@Test
	public void whenMultipleTwoDoublesThenReturnCorrectResult() {
		calc.multiple(10, 5.);
		assertThat(calc.getResult(), is(50.));
	}
	@Test
	public void whenDivTwoDoublesThenReturnCorrectResult() {
		calc.div(10, 5.);
		assertThat(calc.getResult(), is(2.));
	}
}