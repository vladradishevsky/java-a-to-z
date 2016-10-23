package radishevsky;


/** 
  * Class Factorial для вычисления факториала
  * @author vladradishevsky
  * @since 23.10.2016
  * @version 1.3
**/
public class Factorial {
	
	
	/** 
	  * Вычисляет значение факториала от числа num
	  * @param int num
	  * @return BigInteger
	**/
	public int getFactorial(int num)
	{
		if (num < 2) {
			if (num < 0) return 0;
			else return 1;
		}
		int result = 1;
		for (int index = 2; index <= num; index++) result *= index;

		return result;
	}	
}
