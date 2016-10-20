package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PointTest {

	Point point_1 = new Point();
	Point point_2 = new Point();
	
	@Test
	public void whenDistanceToAnotherPointThenReturnCorrectResult() {
		point_1.x = 1.;
		point_1.y = 0.;
		point_2.x = 0.;
		point_2.y = 0.;
		assertThat(point_1.distanceTo(point_2), is(1.));
	}
	@Test
	public void whenDistanceToThisPointThenReturnZero() {
		point_1.x = 50.45;
		point_1.y = 50.45;
		assertThat(point_1.distanceTo(point_1), is(0.));
	}
	@Test
	public void whenDistanceToEqualPointThenReturnZero() {
		point_1.x = 50.45;
		point_1.y = 50.45;
		point_2.x = 50.45;
		point_2.y = 50.45;
		
		assertThat(point_1.distanceTo(point_2), is(0.));
	}

}