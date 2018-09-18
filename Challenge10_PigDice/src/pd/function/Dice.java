package pd.function;

public class Dice {
	private Die d1;
	
	public Dice() {
		this.d1 = new Die();

	}
	
	public int getDie1Value() {
		return this.d1.getValue();
	}

	public void roll() {
		this.d1.roll();
	}
	
	@Override
	public String toString() {		
		return "Die 1: " + getDie1Value();
	}
}
