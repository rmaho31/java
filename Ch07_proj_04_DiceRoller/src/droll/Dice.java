package droll;

public class Dice {
	private Die d1;
	private Die d2;
	
	public Dice() {
		this.d1 = new Die();
		this.d2 = new Die();
	}
	
	public int getDie1Value() {
		return this.d1.getValue();
	}
	
	public int getDie2Value() {
		return this.d2.getValue();
	}
	
	public int getSum() {
		return getDie1Value() + getDie2Value();
	}
	
	public void roll() {
		this.d1.roll();
		this.d2.roll();
	}
	
	public String displaySpecialMessages() {
		String s = "";
		if (getSum() == 7) {
			s = "\nCraps";
		} else if (getSum() == 2) {
			s = "\nSnake Eyes!";
		} else if (getSum() == 12) {
			s = "\nBox Cars!";
		} 
		return s;
	}
	
	@Override
	public String toString() {		
		return "Die 1: " + getDie1Value() + 
			   "\nDie 2: " + getDie2Value() + 
			   "\nTotal: " + getSum() + 
			   displaySpecialMessages();
	}
}
