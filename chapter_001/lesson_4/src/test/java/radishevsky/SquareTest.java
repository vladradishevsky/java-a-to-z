package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/** 
  * Class SquareTest
  * @author vladradishevsky
  * @since 23.10.2016
  * @version 1.1
**/
public class SquareTest {
	
	@Test
	public void whenParamsAreZeroThenReturnZero() {
		Square square = new Square(0d, 0d, 0d);
		assertThat(square.calculate(10), is(0f));
	}
	@Test
	public void whenParamsAreOnesAndXisOneThenReturnThree() {
		Square square = new Square(1d, 1d, 1d);
		assertThat(square.calculate(1), is(3f));
	}	
	
}