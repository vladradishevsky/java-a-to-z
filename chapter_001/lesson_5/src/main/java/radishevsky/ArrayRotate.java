package radishevsky;

/** 
  * Class ArrayRotate для поворота квадратного массива
  * @author vladradishevsky
  * @since 25.10.2016
  * @version 1.0
**/
public class ArrayRotate {
	
	public int[][] values; 
	
	/**
	 * Конструктор(ы)
	**/
	public ArrayRotate(int[][] values) {
		this.values = values;
	}
	public ArrayRotate() {
		this.values = new int[1][1];
		this.values[0][0] = 0;
	}

	/** 
	  * Поворачивает (транспонирует) квадратный массив
	**/
	public void rotateArray() {
		
		for (int i=0; i<this.values.length-1; i++)
		{
			for (int j=i+1; j<this.values[i].length; j++)
			{
				int temp = this.values[j][i];
				this.values[j][i] = this.values[i][j];
				this.values[i][j] = temp;
			}
		}
	}

	/** 
	  * Печатает двумерный массив
	**/
	public void printArray() {
		for (int index = 0; index < this.values.length; index++)
		{
			for (int j = 0; j < this.values[index].length; j++) System.out.printf("%d ", this.values[index][j]);
			System.out.println("");
		}
	}	

}