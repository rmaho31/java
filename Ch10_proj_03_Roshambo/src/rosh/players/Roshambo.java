package rosh.players;

public enum Roshambo {
	ROCK,
	PAPER,
	SCISSORS;
	
	public String toString() {
		String s = "";
		if (this.ordinal() == 0) {
			s = "Rock";
		} else if (this.ordinal() == 1) {
			s = "Paper";
		} else {
			s = "Scissors";
		}
		return s;
	}
}
