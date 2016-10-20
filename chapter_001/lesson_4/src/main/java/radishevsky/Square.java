package radishevsky;

/** 
  * Class Square для работы с квадратными уравнениями y=ax^2 + bx + c
  * @author vladradishevsky
  * @since 20.10.2016
  * @version 1.0
**/
	
public class Square {
	private double a=0., b=0., c=0.;
	
	/** 
	  * Вычисляет значение квадратичной функции
	  * @param int x
	  * @return float
	**/
	public float calculate(int x)
	{
		return (float) ((this.a * (x * x)) + (this.b * x) + this.c);
	}
	
	/** 
	  * Выводит значения квадратичной функции
	  * в диапазоне от start до finish с шагом step
	  * 
	  * @param int start начальное значение аргумента
	  * @param int finish конечное значение аргумента
	  * @param int step шаг аргумента
	**/
	public void show(int start, int finish, int step)
	{
		if (start > finish)
		{
			return;
		}
	
		
		while(start < finish)
		{
			System.out.println("x: " + start + " y: " + calculate(start));
			start = start + step;
		}
		if (start>=finish) 
		{
			System.out.println("x: " + finish + " y: " + calculate(finish));	
		}
	}
	
	public Square(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getA() {
		return this.a;
	}
	public double getB() {
		return this.b;
	}
	public double getC() {
		return this.c;
	}
	
	/** 
	  * Метод main
	**/
	public static void main(String[] args) {
		Square square = new Square(Double.valueOf(args[0]), Double.valueOf(args[1]), Double.valueOf(args[2]));
		square.show(Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5]));
	}
	
	
}