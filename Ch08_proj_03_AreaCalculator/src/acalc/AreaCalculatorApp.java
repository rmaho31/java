package acalc;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator App!\n");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String type = Console.getString("Calculate the area of a circle, square, or rectangle? (c/s/r): ");
			if (type.equalsIgnoreCase("c")) {
				Circle c1 = new Circle(Console.getDouble("\nEnter radius: ", -0.00000000000000001, Double.POSITIVE_INFINITY));
				System.out.println("\nThe area of the Circle you entered is: " + c1.getArea());
			} else if (type.equalsIgnoreCase("s")) {
				Square s1 = new Square(Console.getDouble("\nEnter width: ", -0.00000000000000001, Double.POSITIVE_INFINITY));
				System.out.println("\nThe area of the Square you entered is: " + s1.getArea());
			} else if (type.equalsIgnoreCase("r")) {
				Rectangle r1 = new Rectangle(Console.getDouble("\nEnter width: ", -0.00000000000000001, Double.POSITIVE_INFINITY),
											 Console.getDouble("Enter height: ", -0.00000000000000001, Double.POSITIVE_INFINITY));
				System.out.println("\nThe area of the Rectangle you entered is: " + r1.getArea());				
			}
			
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
		}
		System.out.println("Bye!");	
	}

}
