package tipcalc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Tip Calculator");
		
		Scanner sc = new Scanner(System.in);
		
		
		NumberFormat percent = NumberFormat.getPercentInstance();
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			double price = getDouble(sc, "Cost of a meal: ");
			
			for (double i = .15; i <= .25; i += .05) {
				System.out.println("\n" + percent.format(i));
				
				BigDecimal tip = new BigDecimal(price*i).setScale(2, RoundingMode.HALF_UP);
				System.out.println("Tip amount:\t" + currency.format(tip));
				
				BigDecimal total = new BigDecimal(tip.doubleValue()+ price).setScale(2, RoundingMode.HALF_UP);
				System.out.println("Total amount:\t" + currency.format(total));
				
				
			}
			choice = yOrNo(sc, "\nContinue? (y/n): ");
		}
		sc.close();

	}
	
	public static double getDouble(Scanner sc, String prompt) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid number. Try again.");
            }
            sc.nextLine();  
        }
        return d;
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

}
