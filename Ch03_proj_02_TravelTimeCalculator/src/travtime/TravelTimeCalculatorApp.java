package travtime;

import java.util.Scanner;

public class TravelTimeCalculatorApp {

	public static void main(String[] args) {
		int hours = 0;
		int minutes = 0;
		int milesrem = 0;
		System.out.println("Welcome to the Travel Time Calculator\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			double miles = getDoubleWithinRange(sc, "Enter miles: ", 0, Double.POSITIVE_INFINITY);
			
			double mph = getDoubleWithinRange(sc, "Enter miles per hour: ", 0, Double.POSITIVE_INFINITY);
			
			hours = (int) miles / (int) mph;
			milesrem = (int) miles % (int) mph;
			minutes = (int) (milesrem / (mph/60));
			
			System.out.println("\nEstimated Travel Time\n"
							 +   "---------------------");
			System.out.println("Hours: " + hours);
			System.out.println("Minutes: " + minutes);
			
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
