package ccalc;

import java.util.Scanner;

public class ChangeCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Change Calculator\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int qcount = 0;
			int dcount = 0;
			int ncount = 0;
			int pcount = 0;
			
			System.out.print("Enter number of cents 0-99: ");
			int cents = sc.nextInt();
			
			//steps through coin values subtracting the largest possible and incrementing its count
			while (cents > 0) {
				if (cents >= 25) {
					qcount++;
					cents -= 25;
				} else if (cents >= 10) {
					dcount++;
					cents -= 10;
				} else if (cents >= 5) {
					ncount++;
					cents -= 5;
				} else {
					pcount++;
					cents -= 1;
				}
			}
			
			System.out.println("\nQuarters: " + qcount);
			System.out.println("Dimes: " + dcount);
			System.out.println("Nickels: " + ncount);
			System.out.println("Pennies: " + pcount);
			
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		sc.close();

	}

}
