package radishevsky;

/** 
  * Class CheckSubstring 
  * @author vladradishevsky
  * @since 28.10.2016
  * @version 1.0 fix
**/
public class CheckSubstring {
	
	/** 
	  * Проверяет, является ли строка sub подстрокой origin
	  * @param String origin - строка для проверки
	  * @param String sub - подстрока для проверки
	  * @return boolean - ответ
	**/
	public boolean contains(String origin, String sub)
	{
		char[] c_Origin = origin.toCharArray();
		char[] с_Sub = sub.toCharArray();
		boolean result = false;
		
		for (int originIndex=0; originIndex <= c_Origin.length-с_Sub.length; originIndex++)
		{
			result = true;
			for (int subIndex=0; subIndex<с_Sub.length; subIndex++)
			{
				if (с_Sub[subIndex] != c_Origin[originIndex+subIndex])
				{
					result = false;
					break;
				}
			}
			if (result) break;
		}
		return result;
	}
	
}