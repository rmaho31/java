package droll;

public class Die {
	private int num1;
	
	public Die() {
		this.num1 = 0;
	}
	
	public void roll() {
		this.num1 = (int) (Math.random() * 6) + 1;
	}
	
	public int getValue() {
		return this.num1;
	}
}
