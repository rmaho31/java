package intcalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
				
		System.out.println("Welcome to the Interest Calculator\n");

		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			BigDecimal loanAmount = new BigDecimal(getDoubleWithinRange(sc, "Enter loan amount: ", 0, Double.POSITIVE_INFINITY));
			
			BigDecimal interest = new BigDecimal(getDoubleWithinRange(sc, "Enter interest rate: ", 0, Double.POSITIVE_INFINITY));
			
			//setup currency format
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			
			//convert to currency
			System.out.println("\nLoan amount: "
					+ currency.format(loanAmount));
			
			//setup percent interest format
			NumberFormat percent = NumberFormat.getPercentInstance();
			percent.setMaximumFractionDigits(3);
			
			System.out.println("Interest rate: "
					+ percent.format(interest));
			
			System.out.println("Interest: "
					+ currency.format(loanAmount.multiply(interest).setScale(2, RoundingMode.HALF_UP)));
			
			choice = yOrNo(sc,"\nContinue? (y/n): ");
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
