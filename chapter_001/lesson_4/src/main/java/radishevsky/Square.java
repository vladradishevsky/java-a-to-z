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
	private double a=0d, b=0d, c=0d;
	
	/**
	 * Конструктор(ы)
	**/
	public Square(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
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
	
}