package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest {

	
	@Test
	public void whenParamsAreZeroThenReturnZero() {
		Square square = new Square(0., 0., 0.);
		assertThat(square.calculate(10), is(0f));
	}
	@Test
	public void whenParamsAreOnesAndXisOneThenReturnThree() {
		Square square = new Square(1., 1., 1.);
		assertThat(square.calculate(1), is(3f));
	}	
	
}