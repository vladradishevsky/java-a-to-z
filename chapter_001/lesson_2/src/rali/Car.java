package rali;

public class Car {
	// Поле класса
	private int gas = 0;
	
	public void drive(int value) {
		this.gas = this.gas - value;
	}
	public void fill(int value) {
		this.gas = value;
	}
	public void showGas() {
		System.out.println("Gas: " + this.gas);
	}
}