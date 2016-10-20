package radishevsky;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FigurePropertiesTest {

	Triangle triangle = new Triangle();
	FigureProperties figProperties = new FigureProperties();
	Point point_00 = new Point(0., 0.);
	Point point_01 = new Point(0., 1.);
	Point point_10 = new Point(1., 0.);
	
	
	@Test
	public void whenCreateTriangleThenReturnCorrectResult() {
		
		triangle.a = point_00;
		triangle.b = point_01;
		triangle.c = point_10;
		assertThat(figProperties.max(triangle), is(Math.sqrt(2.)));
	}
	@Test
	public void whenCreateTriangleWith2EqualPointsThenReturnCorrectResult() {
		
		triangle.a = point_00;
		triangle.b = point_00;
		triangle.c = point_10;
		assertThat(figProperties.max(triangle), is(1.));
	}
	@Test
	public void whenCreateTriangleWithAllEqualPointsThenReturnCorrectResult() {
		
		triangle.a = point_00;
		triangle.b = point_00;
		triangle.c = point_00;
		assertThat(figProperties.max(triangle), is(0.));
	}	
}