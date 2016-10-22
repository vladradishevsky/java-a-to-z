package radishevsky;

import java.math.BigInteger;
import java.util.HashMap;


/** 
  * Class Factorial для вычисления факториала
  * @author vladradishevsky
  * @since 22.10.2016
  * @version 1.1
**/
public class Factorial {
	/**
	 * Поле класса
	**/
	private static HashMap<Integer,BigInteger> factorials = new HashMap<Integer,BigInteger>();

	/**
	 * Контруктор
	**/
	public Factorial() {
		factorials.put(0, BigInteger.ONE);
	}
	
	/** 
	 * main
	**/
	public static void main(String[] args)
	{
		Factorial factorial = new Factorial();
		int n = Integer.valueOf(args[0]);
		
		System.out.println("Fact[" + n + "] = " + factorial.getFactorial(n));
	}
	
	/** 
	  * Вычисляет значение факториала от числа n
	  * @param int n
	  * @return BigInteger
	**/
	public BigInteger getFactorial(int n)
	{
		BigInteger result;
		
		if (this.factorials.get(n) != null) return this.factorials.get(n);
		
		result = BigInteger.valueOf(n).multiply(getFactorial(n-1));
		factorials.put(n, result);
		return result;
	}	
}
