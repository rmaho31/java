package acalc;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator App!\n");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String type = Console.getString("Calculate the area of a circle, square, or rectangle? (c/s/r): ");
			Shape s = null;
			if (type.equalsIgnoreCase("c")) {
				s = new Circle(Console.getDouble("\nEnter radius: ", 0, Double.POSITIVE_INFINITY));				
			} else if (type.equalsIgnoreCase("s")) {
				s = new Square(Console.getDouble("\nEnter width: ", 0, Double.POSITIVE_INFINITY));				
			} else if (type.equalsIgnoreCase("r")) {
				s = new Rectangle(Console.getDouble("\nEnter width: ", 0, Double.POSITIVE_INFINITY),
											 Console.getDouble("Enter height: ", 0, Double.POSITIVE_INFINITY));							
			}
			System.out.println("\nThe area of the " + s.getClass().getSimpleName() + " you entered is: " + s.getArea());
			
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		}
		System.out.println("Bye!");	
	}
}
