package radishevsky;

	/** 
	  * Class FigureProperties свойства фигур
	  * @author vladradishevsky
	  * @since 18/10/2016
	  * @version 1.0
	**/
	
public class FigureProperties {
	
	/** 
	  * max - наибольшая сторона треугольника
	  * @param Triangle - треугольник
	  * @return double наибольшую сторону треугольника
	**/
	public double max(Triangle triangle) {
		double temp, max = triangle.a.distanceTo(triangle.b);
		if ((temp = triangle.b.distanceTo(triangle.c)) > max) max = temp;
		if ((temp = triangle.a.distanceTo(triangle.c)) > max) max = temp;
		
		return max;
	}

}