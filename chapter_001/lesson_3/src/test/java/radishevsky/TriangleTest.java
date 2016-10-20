package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.math.*;

public class TriangleTest {

	Triangle triangle = new Triangle();
	Point point_00 = new Point(0., 0.);
	Point point_01 = new Point(0., 1.);
	Point point_10 = new Point(1., 0.);
	Point point_11 = new Point(1., 1.);
	
	@Test
	public void whenCreateTriangleThenReturnCorrectResult() {
		triangle.a = point_00;
		triangle.b = point_01;
		triangle.c = point_10;
		
		assertThat(new BigDecimal(triangle.area()).setScale(5, BigDecimal.ROUND_HALF_UP), is((new BigDecimal(0.5)).setScale(5, BigDecimal.ROUND_HALF_UP)));
	}
	@Test
	public void whenTriangleCantExistThenReturnZero() {
		triangle.a = point_00;		
		triangle.b = point_00;		
		triangle.c = point_11;
		assertThat(new BigDecimal(triangle.area()), is(new BigDecimal(0.)));
	}
}