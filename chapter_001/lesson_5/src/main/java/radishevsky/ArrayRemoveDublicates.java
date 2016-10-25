package radishevsky;

/** 
  * Class ArrayRemoveDublicates для удаления дубликатов в массиве
  * @author vladradishevsky
  * @since 25.10.2016
  * @version 1.0
**/
public class ArrayRemoveDublicates {
	
	public String[] values;
	
	/**
	 * Конструктор(ы)
	**/
	public ArrayRemoveDublicates(String[] values) {
		this.values = values;
	}
	public ArrayRemoveDublicates() {
		this.values = new String[]{""};
	}

	/**
	 * Удаляет дубликаты из массива
	**/
	public void removeAllDublicatesInArray()
	{
		String cuttentValue;
		for (int index=0; index<this.values.length; index++)
		{
			cuttentValue = this.values[index];
			int checkIndex = index + 1;
			while(checkIndex < this.values.length)
			{
				if (this.values[checkIndex].equals(cuttentValue)) remove(checkIndex);
				else checkIndex++;
			}
		}
	}
	
	/** 
	  * Удаляет ячейку заданного индекса из массива (смещает все правостоящие ячейки от индекса влево на один шаг)
	  * @param int index - номер ячейки
	**/
	public void remove(int index)
	{
		String[] result = new String[this.values.length - 1];
		System.arraycopy(this.values, 0, result, 0, index);
		System.arraycopy(this.values, index+1, result, index, result.length-index);
		this.values = result;
	}
	
	
}