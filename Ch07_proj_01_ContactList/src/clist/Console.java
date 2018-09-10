package clist;

import java.util.Scanner;

public class Console {
	public static double getDouble(Scanner sc, String prompt,
            double min, double max) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(sc, prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }

    public static int getInt(Scanner sc, String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt,
            int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(sc, prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }
    
    public static double getDouble(Scanner sc, String prompt) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
    
    public static String getString(Scanner sc, String prompt) {
		String text = "";
		Boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			text = sc.nextLine();
			if (!text.equals("")) {
				isValid = true;
			} else {
				System.out.println("\nError! Must enter a value. Try again.\n");
			}
		}
		return text;
	}
    
    public static String getString(Scanner sc, String prompt, String choice) {
		Boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			choice = sc.nextLine();
			if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
				isValid = true;
			} else {
				System.out.println("\nError! Must enter y or n. Try again.\n");
			}
		}
		return choice;
	}	
}
