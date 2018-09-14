package rosh.players;

public class Bart extends Player {
	
	public Bart() {
		generateRoshambo();
	}

	@Override
	public void generateRoshambo() {
		super.setRoshambo(Roshambo.ROCK);
	}
}
