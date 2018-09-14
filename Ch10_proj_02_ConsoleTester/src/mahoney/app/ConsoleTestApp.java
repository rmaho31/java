package mahoney.app;

import mahoney.presentation.Console;

public class ConsoleTestApp {

	public static void main(String[] args) {
		Console.println("Welcome to the Console Tester Application!\n");
		
		Console.println("Int Test");
		Console.getInt("Enter an int between -100 and 100: ", -100, 100);
		
		Console.println("\nDouble Test");
		Console.getDouble("Enter any number between -100 and 100: ", -100, 100);
		
		Console.println("\nRequired String Test");
		Console.getString("Enter your email address: ");
		
		Console.println("\nString Choice Test");
		Console.getString("Select one (x/y): ", "x", "y");	
	}


}
