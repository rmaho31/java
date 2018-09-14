package rosh.players;

public class Player1 extends Player {
	
	public Player1(String s) {
		if(s.equalsIgnoreCase("r")) {
			super.setRoshambo(Roshambo.ROCK);
		} else if (s.equalsIgnoreCase("p")) {
			super.setRoshambo(Roshambo.PAPER);
		} else {
			super.setRoshambo(Roshambo.SCISSORS);
		}
	}

	@Override
	public void generateRoshambo() {
		
	}

}
