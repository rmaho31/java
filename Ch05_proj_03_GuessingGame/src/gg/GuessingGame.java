package gg;

import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		System.out.println("Welcome to the Guess the Number Game\n" +
						   "++++++++++++++++++++++++++++++++++++\n");
		
		mainLoop(100);
		
		System.out.println("\nBye - come back soon!");

	}
	
	public static void mainLoop(int limit) {
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			System.out.println("I'm thinking of a number from 1 to " + limit + ".\n" +
							   "Try to guess it.\n");
			
			guessCheck(sc, limit);
			
			choice = getYOrN(sc, "\nTry again? (y/n): ");
		}
	}
	
	private static void guessCheck(Scanner sc, int limit) {
		//Checks guesses and Builds display table
		String table = "";
		String header = "";
		String row = "";
		int rnum = getRandom(limit);
		int guess = 0;
		int counter = 0;
		
		do {
			counter++;
			guess = getIntWithinRange(sc, "\nEnter number: ", 0, limit);
			if (rnum > guess) {
				if(rnum - guess > 10) {
					System.out.println("Way too low!");
				} else {
					System.out.println("Too low!");
				}
			} else if (rnum < guess) {
				if(guess - rnum > 10) {
					System.out.println("Way too high!");
				} else {
					System.out.println("Too High!");
				}
			}
		} while (rnum != guess);
		header = "\nNumber of guesses\t" + "Message\n"
				+"=================\t" + "=======\n";
		if (counter <= 3) {
			row = "\t" + counter + "\t\tGreat Work! You are a mathematical wizard.";
		} else if (counter <= 7) {
			row = "\t" + counter + "\t\tNot too bad! You've got some potential.";
		} else {
			row = "\t" + counter + "\t\tWhat took you so long? Maybe you should take some lessons.";
		}
		table = header + row;
		System.out.println(table);
	}

	private static int getRandom(int limit) {
		return (int) (Math.random() * limit) + 1;
	}
	
	private static String getYOrN(Scanner sc, String prompt) {
		String choice = "";
		Boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
				isValid = true;
			} else {
				System.out.println("\nError! Must enter y or n. Try again.");
			}
		}
		System.out.println();
		return choice;
	}		

	private static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
		int i = 0;
		Boolean isValid = false;
		while (!isValid) {
			i = getInt(sc, prompt);
			if (i <= min) {
				System.out.println("\nError! Enter an integer greater than " + min);
			} else if (i >= max) {
				System.out.println("\nError! Enter an integer less than " + max);
			} else {
				isValid = true;
			}
		}
		return i;
	}
	
	private static int getInt(Scanner sc, String prompt) {
		int i = 0;
		Boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				sc.nextLine();
				isValid = true;
			} else { 
				System.out.println("\nError! Invalid integer. Try again.");
				sc.nextLine();
			}
		}
		return i;
	}

}
