package gg;

import java.util.Scanner;

public class Game {
	private int limit;
	private int counter;
	private int guess;
	private int rnum;
	
	public Game(int limit) {
		//Checks guesses and Builds display table
		this.limit = limit;
		this.rnum = 0;
		this.counter = 0;
		this.guess = 0;
	}
	public void mainLoop(int limit) {
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			displayPleaseGuessMessage();
			this.rnum = getRandom(limit);
			this.counter = 0;
			getGuess(sc);
						
			choice = Console.getString("\nTry again? (y/n): ", "y", "n");
		}
		sc.close();
	}
	
	public void displayWelcomeMessage() {
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println();
    }
	
	public void displayPleaseGuessMessage() {
        System.out.println("I'm thinking of a number from 1 to 100.");
        System.out.println("Try to guess it.");
    }
	
	public void displayGoodbye() {
		System.out.println("\nBye - come back soon!");
	}
	
	public void getGuess(Scanner sc) {
		do {
			counter++;
			
			guess = Console.getInt("\nEnter number: ", 0, limit);
			
			displayGuessAgainMessage(rnum, guess);
			
		} while (rnum != guess);
		
		displayCorrectGuessMessage(counter);
		
	}
		
	private static void displayGuessAgainMessage(int rnum, int guess) {
        int difference = guess - rnum;
        if (guess > rnum) {
            if (difference > 10) {
                System.out.println("Way too high! Guess again.");            
            } else {
                System.out.println("Too high! Guess again.");
            }
        } else if (rnum > guess){
            if (difference < -10) {
                System.out.println("Way to low! Guess again.");
            } else {
                System.out.println("Too low! Guess again.");
            }
        }
    }
	
	private static void displayCorrectGuessMessage(int counter) {
        System.out.println("\nYou got it in " + counter + " tries.");
        if (counter <= 3) {
            System.out.println("Great work! You are a mathematical wizard.");
        } else if (counter <= 7) {
            System.out.println("Not too bad! You've got some potential.");
        } else {
            System.out.println("What took you so long? Maybe you should take some lessons.");
        }
    }
	private static int getRandom(int limit) {
		return (int) (Math.random() * limit) + 1;
	}	
	
}
