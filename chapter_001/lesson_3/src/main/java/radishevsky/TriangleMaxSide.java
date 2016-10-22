package radishevsky;

	/** 
	  * Class TriangleMaxSide для вычисления максимальной стороны
	  * @author vladradishevsky
	  * @since 22/10/2016
	  * @version 1.1
	**/
	
public class TriangleMaxSide {
	
	/** 
	  * наибольшая сторона
	  * @param Point[] - точки-вершины геометрической фигуры по порядку
	  * @return double наибольшую сторону фигуры
	**/
	public double maxSide(Point[] points) {
		if (points.length < 2) return 0.;
		
		double temp, maxSide = 0.;
		Point previousPoint = points[0];
		
		for (Point currentPoint : points) {
			temp = currentPoint.distanceTo(previousPoint);
			if (temp > maxSide) maxSide = temp;
			previousPoint = currentPoint;
		}
		return maxSide;
	}
	
	/** 
	  * наибольшая сторона треугольника
	  * @param Triangle - треугольник
	  * @return double наибольшую сторону треугольника
	**/
	public double maxSide(Triangle triangle) {
		return maxSide(triangle.a, triangle.b, triangle.c);
	}

}