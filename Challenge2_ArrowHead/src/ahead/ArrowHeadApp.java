package ahead;

import java.util.Scanner;

public class ArrowHeadApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the Arrowhead line generator App!");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			getArrows(sc, "\nEnter integer number of lines to print: ");
			
			choice = yOrNo(sc, "\nContinue? (y/n): ");
		}
	}
	
	public static void getArrows(Scanner sc, String prompt) {
		int num = getInt(sc, prompt);
		int counter = 0;
		if (num % 2 == 0) {
			num += 1;
		}
		while (true) {
			counter++;
			if (counter <= num/2) {
				for (int i = 0; i < counter % num; i++) {
					System.out.print(">");				
				}	
			} else {
				for (int i = 0; i <= num % counter; i++) {
					System.out.print(">");
				}
			}
			System.out.println();
			
			if (counter == num) {
				break;
			}
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
