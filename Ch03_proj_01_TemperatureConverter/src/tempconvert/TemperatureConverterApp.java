package tempconvert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Temperature Converter\n");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			//grab input from user and apply the conversion formula
			double f = getDouble(sc, "Enter degrees in Fahrenheit: ");
			BigDecimal c = new BigDecimal((f-32)*5/9);
			
			System.out.println("Degrees in Celsius: " + c.setScale(2, RoundingMode.HALF_UP));
			
			choice = yOrNo(sc, "\nContinue? (y/n): ");
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
