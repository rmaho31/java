package ttc.main;

import ttc.functionality.TicTacToe;
import ttc.utility.Console;

public class TicTacToeApp {

	public static void main(String[] args) {
		
		Console.println("Welcome to Tic Tac Toe!\n");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			//declare and initialize game instance with size of game
			TicTacToe ttt = new TicTacToe(Console.getInt("Enter the size of the table: ", 0, Integer.MAX_VALUE),
										  Console.getString("Do you want to play the cpu? (y/n): ", "y", "n"));
			
			/* 
			 * Let the game begin
			 */
			ttt.beginGame();
			
			choice = Console.getString("Play Again? (y/n): ", "y", "n");
		}	
		
		Console.println("Bye - Thanks for playing!");
	}
}
