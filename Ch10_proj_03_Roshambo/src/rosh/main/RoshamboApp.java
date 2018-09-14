package rosh.main;

import rosh.players.*;

public class RoshamboApp {

	public static void main(String[] args) {
		Console.println("Welcome to The Roshambo App!");
		
		String cpuPlayer = Console.getString("Would you like to play Bart or Lisa? (b/n): ", "b", "l");
		
		String player1Name = Console.getString("Enter your name: ");
		
		Player p1 = null;
		Player p2 = null;
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			
			if (cpuPlayer.equalsIgnoreCase("b")) {
				p2 = new Bart();
			} else {
				p2 = new Lisa();
			}
			String p1String = Console.getString("\nRock, paper, scissors? (r/p/s): ", "r", "p", "s");
			
			p1 = new Player1(p1String);
			
			Console.println(player1Name + ": " + roshamboString(p1));
			Console.println(p2.getClass().getSimpleName() + ": " + roshamboString(p2));
			
			checkWinner(p1, p2, player1Name);
			
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");				
		}
		Console.println(player1Name + " won " + p1.getWins() + " games!");
		Console.println(p2.getClass().getSimpleName() + " won " + p2.getWins() + " games!");
	}
	
	public static void checkWinner(Player p1, Player p2, String s) {
		if (roshamboString(p1).equalsIgnoreCase("Rock")) {
			if(roshamboString(p2).equalsIgnoreCase("Rock")) {
				Console.println("Draw!");
			} else if(roshamboString(p2).equalsIgnoreCase("Paper")) {
				Console.println(p2.getClass().getSimpleName() + " Wins!");
				p2.setWins(p2.getWins()+1);
			} else {
				Console.println(s + " Wins!");
				p1.setWins(p1.getWins()+1);
			}
		} else if(p1.toString().equalsIgnoreCase("Paper")) {
			if(roshamboString(p2).equalsIgnoreCase("Paper")) {
				Console.println("Draw!");
			} else if(roshamboString(p2).equalsIgnoreCase("Scissors")) {
				Console.println(p2.getClass().getSimpleName() + " Wins!");
				p2.setWins(p2.getWins()+1);
			} else {
				Console.println(s + " Wins!");
				p1.setWins(p1.getWins()+1);
			}
		}  else {
			if(roshamboString(p2).equalsIgnoreCase("Scissors")) {
				Console.println("Draw!");
			} else if(roshamboString(p2).equalsIgnoreCase("Rock")) {
				Console.println(p2.getClass().getSimpleName() + " Wins!");
				p2.setWins(p2.getWins()+1);
			} else {
				Console.println(s + " Wins!");
				p1.setWins(p1.getWins()+1);
			}
		}
	}
	
	public static String roshamboString(Player p) {
		return p.getRoshambo().toString();
	}
	
}
