package radishevsky;

	/** 
	  * Class Calculate необходим для вычисления арифмитических операций + - * /.
	  * @author vladradishevsky
	  * @since 16/10/2016
	  * @version 1.0
	**/
public class Calculator {
	
	private double result;

	/** 
	  * add - сложение двух чисел
	  * @param first первый аргумент
	  * @param second второй аргумент
	**/
	public void add(double first, double second) {
		this.result = first + second;
	}
	
	/** 
	  * subtract - разность двух чисел
	  * @param first первый аргумент
	  * @param second второй аргумент
	**/
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	
	/** 
	  * multiple - произведение двух чисел
	  * @param first первый аргумент
	  * @param second второй аргумент
	**/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	
	/** 
	  * div - результат деления двух чисел
	  * @param first первый аргумент
	  * @param second второй аргумент
	**/
	public void div(double first, double second) {
		this.result = first / second;
	}
	

	public double getResult() {
		return this.result;
	}
}