package nchecker;

public class NumberCheckerApp {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Number Checker App!\n");

		
		MyConsole console = new MyConsole();
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int x = console.getInt("Enter an integer: ");
			
			if (x % 2 == 0) {
				System.out.println("The number " + x + " is even.");
			} else {
				System.out.println("The number " + x + " is odd.");
			}
			
			choice = console.getString("\nContinue (y/n): ", "y", "n");
		}		
	}
}
