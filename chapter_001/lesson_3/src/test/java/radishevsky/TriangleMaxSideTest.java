package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleMaxSideTest {

	TriangleMaxSide triangleMaxSide = new TriangleMaxSide();
		
	@Test
	public void whenCreateTriangleThenReturnCorrectResult() {
		
		Triangle triangle = new Triangle(new Point(0., 0.), new Point(0., 1.), new Point(1., 0.));
		assertThat(triangleMaxSide.max(triangle), is(Math.sqrt(2.)));
	}
	@Test
	public void whenCreateTriangleWith2EqualPointsThenReturnCorrectResult() {
		
		Triangle triangle = new Triangle(new Point(0., 0.), new Point(0., 0.), new Point(1., 0.));
		assertThat(triangleMaxSide.max(triangle), is(1.));
	}
	@Test
	public void whenCreateTriangleWithAllEqualPointsThenReturnCorrectResult() {
		
		Triangle triangle = new Triangle(new Point(0., 0.), new Point(0., 0.), new Point(0., 0.));
		assertThat(triangleMaxSide.max(triangle), is(0.));
	}
	public void whenCreateOnePointThenReturnZero() {
		
		assertThat(triangleMaxSide.max(new Point(50., 50.)), is(0.));
	}
	public void whenCreateFivePointThenReturnOne() {
		
		assertThat(triangleMaxSide.max(new Point(0., 0.), new Point(5., 0.), new Point(4., 1.), new Point(3., 1.), new Point(2., 1.)), is(5.));
	}	
}