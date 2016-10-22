package radishevsky;

	/** 
	  * Class Point точка
	  * @author vladradishevsky
	  * @since 22/10/2016
	  * @version 1.1
	**/
public class Point 
{
	public double x;
	public double y;

	
	/** 
	  * Конструкторы
	**/
	public Point(double x, double y) 
	{
		this.x = x;
		this.y = y;
	}
	public Point() 
	{
		this.x = 0.;
		this.y = 0.;
	}
	
	/** 
	  * distanceTo - расчет расстояния до заданной точки
	  * @param point - точка
	  * @return результат
	**/
	public double distanceTo(Point point) 
	{
		return Math.sqrt(Math.pow((this.x - point.x), 2.) + Math.pow((this.y - point.y), 2.));
	}
}

