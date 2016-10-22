package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {
	
	@Test
	public void whenDistanceToAnotherPointThenReturnCorrectResult() {

		assertThat((new Point(1., 0.)).distanceTo(new Point(0., 0.)), is(1.));
	}
	@Test
	public void whenDistanceToThisPointThenReturnZero() {
		
		final Point point = new Point(50.45, 50.45);
		assertThat(point.distanceTo(point), is(0.));
	}
	@Test
	public void whenDistanceToEqualPointThenReturnZero() {
		
		final Point first_point = new Point(50.45, 50.45);
		final Point second_point = new Point(50.45, 50.45);
		assertThat(first_point.distanceTo(second_point), is(0.));
	}

}