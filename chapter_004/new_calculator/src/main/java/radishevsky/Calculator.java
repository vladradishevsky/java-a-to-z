package radishevsky;

/**
 * Class Calculator implements the basic arithmetic operations.
 * @author vladradishevsky
 * @since 13/02/2016
 * @version 1.0
 **/
public class Calculator {

	/**
	 * The last result of calculation.
	 */
	protected double result = 0d;

	/** 
	  * Addition of two numbers.
	  * @param first first number.
	  * @param second second number.
	**/
	public void add(double first, double second) {
		this.result = first + second;
	}
	
	/** 
	  * Subtraction of two numbers.
	  * @param first first number.
	  * @param second second number.
	**/
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	
	/** 
	  * Multiplication of two numbers.
	  * @param first first number.
	  * @param second second number.
	**/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
	
	/** 
	  * Division of two numbers.
	  * @param first first number.
	  * @param second second number.
	**/
	public void div(double first, double second) {
		this.result = first / second;
	}

	/**
	 * Get last calculation result.
	 * @return result of last calculation.
	 */
	public double getResult() {
		return this.result;
	}
}