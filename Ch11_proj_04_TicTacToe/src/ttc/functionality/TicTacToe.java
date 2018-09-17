package ttc.functionality;

import ttc.players.Player;
import ttc.utility.Console;

public class TicTacToe {
	private Player[] p;
	private String[][] ttt;
	private String gameBoard;
	private int size;
	private String cpu;
	
	public TicTacToe(int size, String cpu) {
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
		this.cpu = cpu;
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
			
			boolean isValid2 = false;
			if(i == 1 && cpu.equalsIgnoreCase("y")) {
				Console.println(p[i].getLetter()  + "'s turn");
				while(!isValid2) {					
					int[] coord = cpuChoice(p, counter);
					row = coord[0];
					column = coord[1];
					if(ttt[row][column].equals(" ")) {
						isValid2 = true;
						ttt[row][column] = p[i].getLetter();
						updateGameboard();
						Console.println(gameBoard);				
					}
				}
			}
			
			if(i == 1 && cpu.equalsIgnoreCase("n") || i == 0) {
				Console.println(p[i].getLetter()  + "'s turn");
				
				isValid2 = false;
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
			}
			counter++;
			//checks the winner and if no winner and the board is filled it's a tie
			isValid = checkWinner(row, column, size, p[i]);
			if(isValid == true) {
				Console.println(p[i].getLetter() + "'s Win!\n\nGame Over.\n");
			} else if(counter == size*size) {
				Console.println("The Game is a Tie!\n" +
						"\nGame Over!\n");
				isValid = true;
			}
			
			//player switch
			if (i == 1) {
				i--;
			} else {
				i++;
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
	
	//cpu player logic
	public int[] cpuChoice(Player[] p, int counter) {
		int rowIndexMax = 0;
		int colIndexMax = 0;
		int diagIndexMax = 0;
		int maxRow = -1;
		int maxCol = -1;
		int maxDiag = -1;
		int coord[] = new int[2];
		int rowWin = -1;
		int colWin = -1;
		int diagWin = -1;
		for(int i = 0; i < size; i++) {
			if(p[0].getRowSums()[i] > maxRow && p[1].getRowSums()[i] + p[0].getRowSums()[i] != size) {
				maxRow = p[0].getRowSums()[i];
				rowIndexMax = i;
			}
			if(p[1].getRowSums()[i] + p[0].getRowSums()[i] != size && p[1].getRowSums()[i] == size - 1) {
				rowWin = i;
			}
			if(p[0].getColumnSums()[i] > maxCol && p[1].getColumnSums()[i] + p[0].getColumnSums()[i] != size) {
				maxCol = p[0].getColumnSums()[i];
				colIndexMax = i;
			}
			if(p[1].getColumnSums()[i] + p[0].getColumnSums()[i] != size && p[1].getColumnSums()[i] == size - 1) {
				colWin = i;
			}
			if (i < 2) {
				if(p[0].getDiagonalSums()[i] > maxDiag && p[1].getDiagonalSums()[i] + p[0].getDiagonalSums()[i] != size) {
					maxDiag = p[0].getDiagonalSums()[i];
					diagIndexMax = i;
				}
				if(p[1].getDiagonalSums()[i] + p[0].getDiagonalSums()[i] != size && p[1].getDiagonalSums()[i] == size - 1) {
					diagWin = i;
				}
			}
		}
		
		if(counter < 2 && size == 3 && p[0].getDiagonalSums()[0] + p[0].getDiagonalSums()[1] != 2) {
			coord[0] = 1;
			coord[1] = 1;			
		} else if(counter < 2 && size == 3 && p[0].getDiagonalSums()[0] + p[0].getDiagonalSums()[1] == 2) {
			if((int) Math.random() == 1) {
				coord[0] = (int) (Math.random()*size);
				coord[1] = coord[0];			
			} else {
				coord[1] = (int) (Math.random()*size);
				coord[0] = size - coord[1] - 1;	
			}
		} else if(counter < 4 && size == 3 && p[0].getDiagonalSums()[0] + p[1].getDiagonalSums()[0] == size) {
			coord[1] = (int) (Math.random()*size);
			coord[0] = size - coord[1] - 1;		
		} else if(counter < 4 && size == 3 && p[0].getDiagonalSums()[1] + p[1].getDiagonalSums()[1] == size) {
			coord[0] = (int) (Math.random()*size);
			coord[1] = coord[0];
		} else if(rowWin != -1) {
			coord[0] = rowWin;
			coord[1] = (int) (Math.random()*size);			
		} else if(colWin != -1) {
			coord[0] = (int) (Math.random()*size);
			coord[1] = colWin;			
		} else if(diagWin != -1) {
			if(diagWin == 0) {
				coord[0] = (int) (Math.random()*size);
				coord[1] = coord[0];
			} else {
				coord[1] = (int) (Math.random()*size);
				coord[0] = size - coord[1] - 1;
			}	
		} else if(p[1].getDiagonalSums()[0] + p[0].getDiagonalSums()[0] == size && p[1].getDiagonalSums()[1] + p[0].getDiagonalSums()[1] == 1 && size == 3 &&
				p[1].getRowSums()[1] + p[0].getRowSums()[1] != size || p[1].getRowSums()[1] + p[0].getRowSums()[1] != size &&
				p[1].getDiagonalSums()[1] + p[0].getDiagonalSums()[1] == size && p[1].getDiagonalSums()[1] + p[0].getDiagonalSums()[0] == 1 && size == 3 ) {
			coord[0] = 1;
			coord[1] = (int) (Math.random()*size);
		} else if (p[0].getDiagonalSums()[diagIndexMax] > p[0].getRowSums()[rowIndexMax] && 
				   p[0].getDiagonalSums()[diagIndexMax] > p[0].getColumnSums()[colIndexMax]){
			if(diagIndexMax == 0) {
				coord[0] = (int) (Math.random()*size);
				coord[1] = coord[0];
			} else {
				coord[1] = (int) (Math.random()*size);
				coord[0] = size - coord[1] - 1;	
			}
		} else if(p[0].getRowSums()[rowIndexMax] >  p[0].getColumnSums()[colIndexMax]) {
			coord[0] = rowIndexMax;
			coord[1] = (int) (Math.random()*size);
		} else if(p[0].getColumnSums()[colIndexMax] > p[0].getRowSums()[diagIndexMax]) {
			coord[0] = (int) (Math.random()*size);
			coord[1] = colIndexMax;
		
		} else {
			coord[0] = (int) (Math.random()*size);
			coord[1] = (int) (Math.random()*size);
		}
		return coord;
	}
	
	public Player[] getP() {
		return p;
	}

	public void setP(Player[] p) {
		this.p = p;
	}

	public String[][] getTtt() {
		return ttt;
	}

	public void setTtt(String[][] ttt) {
		this.ttt = ttt;
	}

	public String getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(String gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
