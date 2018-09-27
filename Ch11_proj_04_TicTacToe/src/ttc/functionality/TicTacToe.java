package ttc.functionality;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

import ttc.players.Player;
import ttc.players.Score;
import ttc.utility.Console;

public class TicTacToe {
	private Player[] p;
	private String[][] ttt;
	private String gameBoard;
	private int size;
	private String cpu;
	private Score s;
	private String difficulty;
	
	public TicTacToe(int size, String cpu, String difficulty) {
		//initialize players with proper String values
		p = new Player[] {new Player("X", size), new Player("O", size)};		
		s = new Score(size);
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
		this.difficulty = difficulty;
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
					int coord[];
					if(difficulty.equals("1")) {
						coord = cpuChoice(s, counter);
						row = coord[0];
						column = coord[1];
					} else {						
						MiniMax mm = new MiniMax();
						mm.constructTree(ttt);
						mm.checkWin();
						coord = mm.returnBestMove();
						row = coord[0];
						column = coord[1];	
					}
					
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
			adjustScores(row, column, size, p[i], s, ttt);
			//checks the winner and if no winner and the board is filled it's a tie
			isValid = checkWinner(row, column, size, p[i], s, ttt);
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
	
	//increments the scores
	public void adjustScores(int row, int column, int size, Player p, Score s, String[][] ttt) {
		boolean isOpen = true;
		for (String cell : ttt[row]) {
			if(!cell.equals(p.getLetter()) && !cell.equals(" ")) {
				isOpen = false;			
			}	
		} if (isOpen) {
			s.adjustRowSums(row, p);
		} else {
			s.setRowSums(0, row);
		}
		
		isOpen = true;
		for (int i = 0; i < size; i++) {
			if(!ttt[i][column].equals(p.getLetter()) && !ttt[i][column].equals(" ")) {
				isOpen = false;			
			}	
		} if (isOpen) {
			s.adjustColumnSums(column, p);
		} else {
			s.setColumnSums(0, column);
		}
		
		isOpen = true;
		if(row == column) {
			for(int i = 0, j = 0; i < size; i++, j++) {
				if(!ttt[i][j].equals(p.getLetter()) && !ttt[i][j].equals(" ")) {
					isOpen = false;			
				}	
			} if (isOpen) {
				s.adjustDiagonalSums(0, p);
			} else {
				s.setDiagonalSums(0, 0);
			}			
		}
		
		if(row == size - column - 1) {
			isOpen = true;
			for(int i = 0, j = size - i - 1; i < size; i++, j--) {
				if(!ttt[i][j].equals(p.getLetter()) && !ttt[i][j].equals(" ")) {
					isOpen = false;			
				}	
			} if (isOpen) {
				s.adjustDiagonalSums(1, p);
			} else {
				s.setDiagonalSums(0, 1);
			}			
		}
	}
	
	public boolean checkWinner(int row, int column, int size, Player p, Score s, String[][] ttt) {
			for(int score : s.getRowSums()) {
			if (Math.abs(score) == Math.pow(10, size-1)) {
				return true;
			}
		}
		for(int score : s.getColumnSums()) {
			if (Math.abs(score) == Math.pow(10, size-1)) {
				return true;
			}
		}
		for(int score : s.getDiagonalSums()) {
			if (Math.abs(score) == Math.pow(10, size-1)) {
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
	
	//cpu player logic first try
	public int[] cpuChoice(Score s, int counter) {
		int rowIndexMax = 0;
		int colIndexMax = 0;
		int diagIndexMax = 0;
		int maxRow = -1;
		int maxCol = -1;
		int maxDiag = -1;
		int coord[] = new int[2];
		int rowWin = 0;
		int colWin = 0;
		int diagWin = 0;
		for(int i = 0; i < size; i++) {
			if(Math.abs(s.getRowSums()[i]) > maxRow) {
				maxRow = s.getRowSums()[i];
				rowIndexMax = i;
			}
			if(s.getRowSums()[i] == -Math.pow(10, size - 2)) {
				rowWin = i;
			}
			if(Math.abs(s.getColumnSums()[i]) > maxCol) {
				maxCol = s.getColumnSums()[i];
				colIndexMax = i;
			}
			if(s.getColumnSums()[i] == -Math.pow(10, size - 2)) {
				colWin = i;
			}
			if (i < 2) {
				if(Math.abs(s.getDiagonalSums()[i]) > maxDiag) {
					maxDiag = s.getDiagonalSums()[i];
					diagIndexMax = i;
				}
				if(s.getDiagonalSums()[i] == Math.pow(10, size - 2)) {
					diagWin = i;
				}
			}
		}
		
		if(s.getRowSums()[rowWin] == -Math.pow(10, size-2)) {
			coord[0] = rowWin;
			coord[1] = (int) (Math.random()*size);			
		} else if(s.getColumnSums()[colWin] == -Math.pow(10, size-2)) {
			coord[0] = (int) (Math.random()*size);
			coord[1] = colWin;			
		} else if(s.getDiagonalSums()[diagWin] == -Math.pow(10, size-2)) {
			if(diagWin == 0) {
				coord[0] = (int) (Math.random()*size);
				coord[1] = coord[0];
			} else {
				coord[1] = (int) (Math.random()*size);
				coord[0] = size - coord[1] - 1;
			}	
		} else if(s.getDiagonalSums()[diagIndexMax] > s.getRowSums()[rowIndexMax] && 
				  s.getDiagonalSums()[diagIndexMax] > s.getColumnSums()[colIndexMax]) {
			if(diagIndexMax == 0) {
				coord[0] = (int) (Math.random()*size);
				coord[1] = coord[0];
			} else {
				coord[1] = (int) (Math.random()*size);
				coord[0] = size - coord[1] - 1;
			}	
		} else if(s.getRowSums()[rowIndexMax] > s.getColumnSums()[colIndexMax] &&
				  s.getRowSums()[rowIndexMax] > s.getDiagonalSums()[diagIndexMax]) {
			coord[0] = rowIndexMax;
			coord[1] = (int) (Math.random()*size);
		} else if(s.getColumnSums()[colIndexMax] > s.getRowSums()[rowIndexMax] &&
				  s.getColumnSums()[colIndexMax] > s.getDiagonalSums()[diagIndexMax]) {
			coord[0] = (int) (Math.random()*size);
			coord[1] = colIndexMax;
		} else {
			coord[0] = (int) (Math.random()*size);
			coord[1] = (int) (Math.random()*size);
		}
		
		return coord;
	}
	
	//returns remaining moves available
  	public static ArrayList<int[]> generateMoves(String[][] ttt) {
  		int size = ttt[0].length;
  		ArrayList<int[]> moves = new ArrayList<>();
  		for(int i = 0; i < size; i++) {
  			for(int j = 0; j < size; j++) {
  				if(ttt[i][j].equals(" ")) {
  					int[] x = {i, j};
  					moves.add(x);
  				}
  			}
  		}
  		return moves;
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
