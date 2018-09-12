package rectanglecalculator;

import java.util.Scanner;

public class RectangleCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Area and Perimeter Calculator\n");
		
		String choice = "y";
		Scanner sc = new Scanner(System.in);
		//prompts user for input values
		while (choice.equalsIgnoreCase("y")) {	
			
			Rectangle.setLength(getDoubleWithinRange(sc, "Enter length: ", 0, Double.POSITIVE_INFINITY));
			
			Rectangle.setWidth(getDoubleWithinRange(sc, "Enter width: ", 0, Double.POSITIVE_INFINITY));
			
			System.out.println("Area: " + Rectangle.getArea(Rectangle.getWidth(), Rectangle.getLength()));
			
			System.out.println("Perimeter: " + Rectangle.getPerimeter(Rectangle.getWidth(), Rectangle.getLength()));
			
			choice = yOrNo(sc, "\nContinue? (y/n):");
		}
		sc.close();
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
	
	public static double getDoubleWithinRange(Scanner sc, String prompt, double min, double max) {
        double i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getDouble(sc, prompt);
            if (i <= min) {
                System.out.println(
                        "\nError! Number must be greater than " + min + ".\n");
            } else if (i >= max) {
                System.out.println(
                        "\nError! Number must be less than " + max + ".\n");
            } else {
                isValid = true;
            }
        }
        return i;
    }

	public static double getDouble(Scanner sc, String prompt) {
        double i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                i = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double. Try again.\n");
            }
            sc.nextLine();  
        }
        return i;
    }

}
