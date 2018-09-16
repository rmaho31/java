package sc.main;

import sc.business.StackCalculator;
import sc.utilty.Console;

public class StackCalculatorApp {

	public static void main(String[] args) {
		Console.println("Welcome to the Stack Calculator");
		
		
		StackCalculator sc = new StackCalculator();
		
		boolean isValid = false;
		while(!isValid) {
			displayCmdList();
			
			int selection = Console.getInt("stack> ", 0, 8);

			isValid = runSelectedOperation(selection, sc);
		}
		
		Console.println("\nThanks for using the Stack Calculator");

	}
	
	public static void displayCmdList() {
		Console.println("COMMANDS");
		Console.println("1. push");
		Console.println("2. add");
		Console.println("3. sub");
		Console.println("4. mult");
		Console.println("5. div");
		Console.println("6. clear");
		Console.println("7. quit\n");
	}
	
	public static boolean runSelectedOperation(int selection, StackCalculator sc) {
		if(selection == 1) {
			sc.push(Console.getDouble("Number to push: "));
			Console.println(sc.toString());
		} else if (selection == 2) {
			if (sc.size() > 1) {
				sc.push(sc.add());
				Console.println(sc.toString());
			} else {
				Console.println("Must have two values to run operations!");
			}
		} else if (selection == 3) {
			if (sc.size() > 1) {
				sc.push(sc.subtract());
				Console.println(sc.toString());
			} else {
				Console.println("Must have two values to run operations!");
			}
		} else if (selection == 4) {
			if (sc.size() > 1) {
				sc.push(sc.multiply());
				Console.println(sc.toString());
			} else {
				Console.println("Must have two values to run operations!");
			}
		} else if (selection == 5) {
			if (sc.size() > 1) {
				sc.push(sc.divide());
				Console.println(sc.toString());
			} else {
				Console.println("Must have two values to run operations!");
			}
		} else if (selection == 6) {
			sc.clear();
			Console.println(sc.toString());
		} else {
			return true;
		}
		return false;
	}
}
