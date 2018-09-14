package ttc.functionality;

import ttc.players.Player;
import ttc.utility.Console;

public class TicTacToe {
	private Player[] p;
	private String[][] ttt;
	private String gameBoard;
	
	public TicTacToe() {
		p = new Player[] {new Player("X"), new Player("O")};		
		
		ttt = new String[3][3];
		for (int i = 0; i < ttt.length; i++) {
			for (int j = 0; j <  ttt[i].length; j++) {
				ttt[i][j] = " ";
			}
		}
		
		gameBoard = "+---+---+---+\n" +
				   "| "+ttt[0][0]+" | "+ttt[0][1]+" | "+ttt[0][2]+" |\n" +
				   "+---+---+---+\n" +
				   "| "+ttt[1][0]+" | "+ttt[1][1]+" | "+ttt[1][2]+" |\n" +
				   "+---+---+---+\n" +
				   "| "+ttt[2][0]+" | "+ttt[2][1]+" | "+ttt[2][2]+" |\n" +
				   "+---+---+---+\n";
		
	}

	/**
	 * @return the p
	 */
	public Player[] getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(Player[] p) {
		this.p = p;
	}

	/**
	 * @return the ttt
	 */
	public String[][] getTtt() {
		return ttt;
	}

	/**
	 * @param ttt the ttt to set
	 */
	public void setTtt(String[][] ttt) {
		this.ttt = ttt;
	}

	/**
	 * @return the gameBoard
	 */
	public String getGameBoard() {
		return gameBoard;
	}

	/**
	 * @param gameBoard the gameBoard to set
	 */
	public void setGameBoard(String gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public void beginGame() {
		boolean isValid = false;
		int i = 0;
		int counter = 0;
		Console.println(getGameBoard());
		while(!isValid) {
			boolean isValid2 = false;
			int row = 0, column = 0;
			
		
			Console.println(p[i].getLetter()  + "'s turn");
			
			while(!isValid2) {
				row = Console.getInt("Pick a row: (1, 2, 3): ", 0, 4) - 1;
				column = Console.getInt("Pick a column: (1, 2, 3): ", 0, 4) - 1;
				if(ttt[row][column].equals(" ")) {
					isValid2 = true;
				} else {
					Console.println("\nError! Someone has Placed here already Try again!\n ");						
				}
			}
			
			ttt[row][column] = p[i].getLetter();
			
			setGameBoard("+---+---+---+\n" +
					   "| "+ttt[0][0]+" | "+ttt[0][1]+" | "+ttt[0][2]+" |\n" +
					   "+---+---+---+\n" +
					   "| "+ttt[1][0]+" | "+ttt[1][1]+" | "+ttt[1][2]+" |\n" +
					   "+---+---+---+\n" +
					   "| "+ttt[2][0]+" | "+ttt[2][1]+" | "+ttt[2][2]+" |\n" +
					   "+---+---+---+\n");
			
			Console.println(getGameBoard());
			
			isValid = testWinScenarios(p[i], ttt, isValid);
			
			if (i == 1) {
				i--;
			} else {
				i++;
			}
			
			counter++;
			if(counter == 9 && isValid == false) {
				Console.println("\nThe Game is a Tie!\n" +
								"\nGame Over!\n");
				isValid = true;
			}
		}
	}
	
	public boolean testWinScenarios(Player p1, String[][] ttt, boolean isValid) {
		if (ttt[1][1].equalsIgnoreCase(p1.getLetter())){
			if (ttt[0][0].equalsIgnoreCase(p1.getLetter())){
				if (ttt[2][2].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			} else if (ttt[0][1].equalsIgnoreCase(p1.getLetter())){
				if (ttt[2][1].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			} else if (ttt[1][0].equalsIgnoreCase(p1.getLetter())){
				if (ttt[1][2].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			} else if (ttt[2][0].equalsIgnoreCase(p1.getLetter())){
				if (ttt[0][2].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			}
		} else if (ttt[0][0].equalsIgnoreCase(p1.getLetter())){
			if (ttt[1][0].equalsIgnoreCase(p1.getLetter())){
				if (ttt[2][0].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			} else if (ttt[0][1].equalsIgnoreCase(p1.getLetter())){
				if (ttt[0][2].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			}
		} else if (ttt[2][2].equalsIgnoreCase(p1.getLetter())){
			if (ttt[2][1].equalsIgnoreCase(p1.getLetter())){
				if (ttt[2][0].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			} else if (ttt[1][2].equalsIgnoreCase(p1.getLetter())){
				if (ttt[0][2].equalsIgnoreCase(p1.getLetter())){
					Console.println(p1.getLetter() + " wins!");
					Console.println("\nGame Over!");
					isValid = true;
				}
			}
		}
		return isValid;
	}
}
