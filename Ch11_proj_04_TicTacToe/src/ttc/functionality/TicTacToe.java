package ttc.functionality;

import ttc.players.Player;
import ttc.utility.Console;

public class TicTacToe {
	private Player[] p;
	private String[][] ttt;
	private String gameBoard;
	private int size;
	
	public TicTacToe(int size) {
		//initialize players with proper String values
		p = new Player[] {new Player("X", size), new Player("O", size)};		
		
		this.size = size;
		//fills array with spaces and builds the game board
		ttt = new String[size][size];
		gameBoard = "";
		for (int i = 0; i < ttt.length; i++) {
			String lines = "";
			String middle = "";
			for (int j = 0; j <  ttt[i].length; j++) {
				ttt[i][j] = " ";
				lines += "+---";
				middle += "| " + ttt[i][j] + " ";
			}
			lines += "+\n";
			middle += "|\n";
			if(i != size - 1) {
				gameBoard += lines + middle;
			} else {
				gameBoard += lines + middle + lines;
			} 
		}
	}

	

	/**
	 * Begins the Tic Tac Toe game. Gets input from the user
	 *  and places X or O into specified place in the matrix. 
	 * Input ranges prohibit the user from entering an index
	 *  that is out of bounds. If the space has been entered
	 * already it will re-prompt the user. The updated board
	 *  is displayed and the matrix is evaluated for winning conditions.
	 * If the winning conditions aren't met and all the 
	 * spaces have been filled the loop ends displaying a tie.
	 */
	public void beginGame() {
		boolean isValid = false;
		int i = 0;
		int counter = 0;
		Console.println(gameBoard);
		while(!isValid) {
			int row = 0;
			int column = 0;
					
			Console.println(p[i].getLetter()  + "'s turn");
			
			boolean isValid2 = false;
			while(!isValid2) {
				row = Console.getInt("Pick a row: (1,2,3...): ", 0, size + 1) - 1;
				column = Console.getInt("Pick a column: (1, 2, 3...): ", 0, size + 1) - 1;
				if(ttt[row][column].equals(" ")) {
					isValid2 = true;
					ttt[row][column] = p[i].getLetter();
					updateGameboard();
					Console.println(gameBoard);
				} else {
					Console.println("\nSomeone has Placed here already Try again!");
					Console.println(gameBoard);
				}
			}
			
			isValid = checkWinner(row, column, size, p[i]);
			if(isValid == true) {
				Console.println(p[i].getLetter() + "'s Win!\n\nGame Over.\n");
			}
			
			//player switch
			if (i == 1) {
				i--;
			} else {
				i++;
			}
			
			//if the game reaches this point it's a tie and the game ends
			counter++;
			if(counter == size*size && isValid == false) {
				Console.println("The Game is a Tie!\n" +
								"\nGame Over!\n");
				isValid = true;
			}
		}
	}
	
	//adds to the player score counts and checks them against the size of the board
	public boolean checkWinner(int row, int column, int size, Player p) {
		p.incrementRowSums(row);
		p.incrementColumnSums(column);
		if (row == column) { 
			p.incrementDiagonalSums(0);
		}
		if (row == size - 1 - column) {
			p.incrementDiagonalSums(1);
		}
		for(int score : p.getRowSums()) {
			if (score == size) {
				return true;
			}
		}
		for(int score : p.getColumnSums()) {
			if (score == size) {
				return true;
			}
		}
		for(int score : p.getDiagonalSums()) {
			if (score == size) {
				return true;
			}
		}
		return false;
	}
	
	public void updateGameboard() {
		gameBoard = "\n";
		for (int i = 0; i < ttt.length; i++) {
			String lines = "";
			String middle = "";
			for (int j = 0; j <  ttt[i].length; j++) {
				lines += "+---";
				middle += "| "+ttt[i][j]+" ";
			}
			lines += "+\n";
			middle += "|\n";
			if(i != size - 1) {
				gameBoard += lines + middle;
			} else {
				gameBoard += lines + middle + lines;
			} 
		}
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
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
