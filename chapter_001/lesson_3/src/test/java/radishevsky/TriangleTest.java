package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.math.*;

public class TriangleTest {
	
	@Test
	public void whenCreateTriangleThenReturnCorrectResult() {
		
		Triangle triangle = new Triangle(new Point(0., 0.), new Point(0., 1.), new Point(1., 0.));
		assertThat(new BigDecimal(triangle.area()).setScale(5, BigDecimal.ROUND_HALF_UP), is((new BigDecimal(0.5)).setScale(5, BigDecimal.ROUND_HALF_UP)));
	}
	@Test
	public void whenTriangleCantExistThenReturnZero() {
		
		Triangle triangle = new Triangle(new Point(0., 0.), new Point(0., 0.), new Point(1., 1.));
		assertThat(new BigDecimal(triangle.area()), is(new BigDecimal(0.)));
	}
}