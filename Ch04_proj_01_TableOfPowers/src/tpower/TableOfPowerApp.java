package tpower;

import java.util.Scanner;

public class TableOfPowerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Squares and Cubes Table\n");
		
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {	
						
			int num = getInt(sc, "Enter an integer: ");
			
			System.out.println("\nNumber  Square  Cubed");
			System.out.println("======  ======  =====");
			
			for (int i = 1; i <= num; i++) {
				System.out.println(i + "\t" + i*i + "\t" + i*i*i);
			}
			
			choice = yOrNo(sc, "\nContinue? (y/n): ");
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
                System.out.println("\nError! Invalid integer. Try again.\n");
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