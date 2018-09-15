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
			
			int cents = getIntWithinRange(sc, "Enter number of cents 0-99: ", 0, 99);
			
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
	
	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
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

	public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer. Try again.\n");
            }
            sc.nextLine();  
        }
        return i;
    }

}
