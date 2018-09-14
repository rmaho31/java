package rosh.players;

public abstract class Player {
	private Roshambo roshambo;
	private int wins;
	
	public abstract void generateRoshambo();

	/**
	 * @return the roshambo
	 */
	public Roshambo getRoshambo() {
		return roshambo;
	}

	/**
	 * @param roshambo the roshambo to set
	 */
	public void setRoshambo(Roshambo roshambo) {
		this.roshambo = roshambo;
	}

	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * @param wins the wins to set
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

	

}
