package droll;

public class DiceRollApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller!");

		String choice = "";
		choice = Console.getString("\nRoll Dice? (y/n): ", "y", "n");
		while(choice.equalsIgnoreCase("y")) {
			Dice dice = new Dice();
			dice.roll();
			System.out.println(dice);
			choice = Console.getString("\nRoll again? (y/n): ", "y", "n");
		}
		
		System.out.println("\nBye");

	}

}
