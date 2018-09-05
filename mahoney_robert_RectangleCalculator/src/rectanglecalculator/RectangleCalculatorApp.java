package rectanglecalculator;

import java.util.Scanner;

public class RectangleCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area and Perimeter Calculator\n");
		
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		//prompts user for input values
		while (choice.equalsIgnoreCase("y")) {	
			System.out.print("Enter length: ");
			Rectangle.setLength(sc.nextDouble());
			
			System.out.print("Enter width: ");
			Rectangle.setWidth(sc.nextDouble());
			
			System.out.println("Area: " + Rectangle.getArea(Rectangle.getWidth(), Rectangle.getLength()));
			
			System.out.println("Perimeter: " + Rectangle.getPerimeter(Rectangle.getWidth(), Rectangle.getLength()));
			
			System.out.print("\nContinue? (y/n):");
			choice = sc.next();
			System.out.println();
			
		}
		sc.close();
	}
}
