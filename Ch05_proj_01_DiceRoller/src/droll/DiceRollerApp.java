package droll;

import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {
		System.out.println("Dice Roller");
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		
		choice = yOrNo(sc,"\nRoll the dice? (y/n): ");
		while (choice.equalsIgnoreCase("y")) {
			int d1 = getDieRoll();
			System.out.println("Die 1: " + d1);
			
			int d2 = getDieRoll();
			System.out.println("Die 2: " + d2);
			
			int sum = d1 + d2;
			System.out.println("Total: " + sum);
			
			if (sum == 2) {
				System.out.println("Snake Eyes!");
			} else if (sum == 12) {
				System.out.println("Box Cars!");
			}
			
			choice = yOrNo(sc,"\nRoll the dice? (y/n): ");
		}
	}
	public static int getDieRoll() {
		return (int) (Math.random()*6) + 1;
	}
	
		
	private static String yOrNo(Scanner sc, String prompt) {
		String choice = "";
		while (true) {
			System.out.print(prompt);
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
				break;
			} else {
				System.out.println("\nError! Must enter y or n. Try again.");
			}
		}
		System.out.println();
		return choice;
	}	
}

			   	
			   	
			   		
			   	
