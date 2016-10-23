package radishevsky;

/** 
  * Class Square для работы с квадратными уравнениями y=ax^2 + bx + c
  * @author vladradishevsky
  * @since 23.10.2016
  * @version 1.1
**/
	
public class Square {
	/**
	 * Параметры функции ax^2 + bx + c
	 * по умолчанию 0
	**/
	private double a, b, c;
	
	/**
	 * Конструктор(ы)
	**/
		public Square() {
		this.a = 0d;
		this.b = 0d;
		this.c = 0d;
	}
	public Square(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * Getters
	**/
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
			System.out.printf("x: %d y: %.4f\n", start, calculate(start));
			start = start + step;
		}
		if (start>=finish) System.out.printf("x: %d y: %.4f\n", finish, calculate(finish));
	}

	
}