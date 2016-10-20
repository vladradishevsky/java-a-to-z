package radishevsky;
	
	/** 
	  * Class Triangle треугольник
	  * @author vladradishevsky
	  * @since 18/10/2016
	  * @version 1.0
	**/
public class Triangle
{
	public Point a;
	public Point b;
	public Point c;
	
	public Triangle()
	{
		this.a = new Point(0. , 0.);
		this.b = this.a;
		this.c = this.a;
	}
	public Triangle(Point a, Point b, Point c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/** 
	  * area - расчет площади треугольника
	  * @return площадь треугольника
	**/
	public double area()
	{
		//расчет площади треугольника
		double ab = (this.a).distanceTo(this.b);
		double bc = (this.b).distanceTo(this.c);
		double ac = (this.a).distanceTo(this.c);		
		
		if ((ab < bc + ac) && (bc < ab + ac) && (ac < ab + bc)) {
			// Формула Герона			
			return 0.25 * Math.sqrt(Math.pow(ab*ab + bc*bc + ac*ac, 2.) - 2 * (Math.pow(ab, 4.) + Math.pow(bc, 4.) + Math.pow(ac, 4.)));
		}
		else {
			// Треугольник вырождается в отрезок
			return 0.;
		}
			
	}
}