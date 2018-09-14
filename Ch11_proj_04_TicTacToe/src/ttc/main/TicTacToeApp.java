package ttc.main;

import ttc.functionality.TicTacToe;
import ttc.utility.Console;

public class TicTacToeApp {

	public static void main(String[] args) {
		
		Console.println("Welcome to Tic Tac Toe!\n");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			//declare and initialize game instance
			TicTacToe ttt = new TicTacToe();
			
			/* 
			 * initializes the Tic Tac Toe game check TicTacToe class for methods
			 */
			ttt.beginGame();
			
			choice = Console.getString("Play Again? (y/n): ", "y", "n");
		}	
	}
	
	
}
