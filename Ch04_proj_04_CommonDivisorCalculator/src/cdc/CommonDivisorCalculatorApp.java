package cdc;

import java.util.Scanner;

public class CommonDivisorCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Greatest Common Divisor Finder");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int num1 = getInt(sc,"Get First number: ");
			
			int num2 = getInt(sc,"Get Second number: ");
			
			int i = Math.min(num1, num2);
			
			while(num1 % i != 0 || num2 % i != 0) {
				i--;
			}
			
			System.out.println("Greatest common divisor: " + i);
			choice = yOrNo(sc,"\nContinue? (y/n): ");
		}
		sc.close();
		

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
                System.out.println("Error! Invalid integer. Try again.");
            }
            sc.nextLine();  
        }
        return i;
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
