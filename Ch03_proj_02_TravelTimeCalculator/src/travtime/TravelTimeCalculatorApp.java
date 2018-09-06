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
			System.out.print("Enter miles: ");
			double miles = sc.nextDouble();
			
			System.out.print("Enter miles per hour: ");
			double mph = sc.nextDouble();
			
			hours = (int) miles / (int) mph;
			milesrem = (int) miles % (int) mph;
			minutes = (int) (milesrem / (mph/60));
			
			System.out.println("\nEstimated Travel Time\n"
							 +   "---------------------");
			System.out.println("Hours: " + hours);
			System.out.println("Minutes: " + minutes);
			
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
			System.out.println();
			
		}
		sc.close();

	}

}
