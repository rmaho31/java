package pnc.main;

import java.util.ArrayList;

import pnc.business.PrimeNumberCalc;
import pnc.utility.Console;

public class PrimeNumberCheckerApp {

	public static void main(String[] args) {
		Console.println("Prime Number Checker\n");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			int number = Console.getInt("Please enter a number between 1 and 5000: ", 0, 5000);
			
			PrimeNumberCalc pnc = new PrimeNumberCalc(number);
			
			boolean isPrime = pnc.checkPrime();
			
			if (isPrime == true) {
				Console.println("\n" + number + " is a prime number.");
			} else {
				ArrayList<Integer> factors = new ArrayList<Integer>(pnc.returnFactors());
				
				Console.println("\n" + number + " is NOT a prime number.");
				
				String numbers = "";
				
				for(int n : factors) {
					numbers += n + " ";
				}
				
				Console.println("It has " + factors.size() + " factors: " + numbers);
			}
			
			choice = Console.getString("\nTry again? (y/n): ", "y", "n");
			
		}

	}

}
