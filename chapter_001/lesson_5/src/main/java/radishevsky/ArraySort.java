package radishevsky;

/** 
  * Class ArraySort для сортировки массивов
  * @author vladradishevsky
  * @since 23.10.2016
  * @version 1.0 fix2
**/
public class ArraySort {

	private int[] values;
	
	/**
	 * Конструктор(ы)
	**/
	public ArraySort(int[] values) {
		this.values = values;
	}
	
	/**
	 * setters
	**/
	public void setValues(int[] values) {
		this.values = values;
	}
	
	/**
	 * getters
	**/
	public int[] getValues() {
		return this.values;
	}

	/** 
	  * Сортирует массив int[] values методом пузырька
	**/
	public void bubbleSort()
	{
		boolean isSwapped;
		for (int i=0; i < values.length - 1; i++) {
			isSwapped = false;
			for (int j=0; j < values.length - i - 1; j++)
			{
				if (values[j] > values[j+1])
				{
					swapInValues(j, j+1);
					isSwapped = true;
				}
			}
			if (!isSwapped) break;
		}
		
	}
	
	/** 
	  * Меняет местами значения двух ячеек массива
	  * @param int first - номер первой ячейки
	  * @param int second - номер второй ячейки
	**/
	private void swapInValues(int first, int second)
	{
		int temp = values[second];
		values[second] = values[first];
		values[first] = temp;
	}
}