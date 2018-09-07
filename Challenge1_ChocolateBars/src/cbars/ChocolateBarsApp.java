package cbars;

import java.util.Scanner;

public class ChocolateBarsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Chocolate Factory!\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			int sb = makeChocolate(getInt(sc,"\nEnter number of small bars(1kg): "), getInt(sc, "\nEnter number of large bars(5kg): "),
								 getInt(sc,"\nEnter goal(kg): "));
			if (sb > 0) {
				System.out.println("\nYou needed " + sb + " small chocolate bars!");
			} else {
				System.out.println("\nYou do not have enough chocolate to reach your goal.");
			}
			
			choice = yOrNo(sc, "\nContinue? (y/n): ");
		}
		
		

	}
	
	public static int makeChocolate(int small, int big, int goal) {
		int i = 0;
		while (goal > 0 && small > 0) {
			if (goal > 5 && big > 0) {
				goal -= 5;
				big--;
			} else if (goal >= 1) {
				goal -= 1;
				small--;
				i++;
			}
		}
		if (goal != 0) {
			return -1;
		} else {
			return i;
		}
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
            sc.nextLine();  // discard any other data entered on the line
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
