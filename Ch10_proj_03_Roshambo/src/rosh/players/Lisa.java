package rosh.players;

public class Lisa extends Player {
	
	public Lisa() {
		generateRoshambo();
	}

	@Override
	public void generateRoshambo() {
		int i = (int) (Math.random()*3) + 1;
		if (i == 1) {
			setRoshambo(Roshambo.ROCK);
		} else if (i == 2) {
			setRoshambo(Roshambo.PAPER);
		} else {
			setRoshambo(Roshambo.SCISSORS);
		}
	}
	
}
