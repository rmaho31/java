
public class CalculatorApp {

	public static void main(String[] args) {
		Console.println("Welcome to the Calculator App.");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			
			Calculator c = new Calculator();
			
			c.setNum1(Console.getInt("Enter number: "));
			
			String operation = Console.getString("\n1. Add\n2. Subtract\n", "1", "2");
			
			if(operation.equalsIgnoreCase("1")) {
				c.setNum2(Console.getInt("Enter number to add: "));
				Console.println("\nThe result is " + c.add() + ".");
			} else {
				c.setNum2(Console.getInt("Enter number to subtract: "));
				Console.println("The result is " + c.subtract() + ".");
			}
			
			
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}

	}

}
