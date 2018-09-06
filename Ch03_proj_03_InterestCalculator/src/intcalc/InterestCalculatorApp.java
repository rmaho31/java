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
			System.out.print("Enter loan amount: ");
			BigDecimal loanAmount = new BigDecimal(sc.next());
			
			System.out.print("Enter interest rate: ");
			BigDecimal interest = new BigDecimal(sc.next());
			
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
			
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		sc.close();
	}

}
