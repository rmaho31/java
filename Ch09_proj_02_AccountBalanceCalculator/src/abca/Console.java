package abca;

import java.util.Scanner;

public class Console {
	private static Scanner sc = new Scanner(System.in);
	
	public static double getDouble(String prompt, double min, double max) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "\nError! Number must be greater than or equal to " + min + ".\n");
            } else if (d >= max) {
                System.out.println(
                        "\nError! Number must be less than or equal to " + max + ".\n");
            } else {
                isValid = true;
            }
        }
        return d;
    }

    public static int getInt(String prompt) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid integer value. Try again.\n");
            }
            sc.nextLine(); //discards
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
            if (i < min) {
                System.out.println(
                        "\nError! Number must be greater than or equal to " + min + ".\n");
            } else if (i > max) {
                System.out.println(
                        "\nError! Number must be less than or equal to " + max + ".\n");
            } else {
                isValid = true;
            }
        }
        return i;
    }
    
    public static double getDouble(String prompt) {
        double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid decimal value. Try again.\n");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
    
    public static String getString(String prompt) {
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
    
    public static String getString(String prompt, String s1, String s2) {
		String s = "";
    	Boolean isValid = false;
		while (!isValid) {
			s = getString(prompt);
			if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
				System.out.println("\nError! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.\n");
			} else {
				isValid = true;
				System.out.println();
			}
		}
		return s;
	}
    
    public static String getString(String prompt, String s1, String s2, String s3) {
		String s = "";
    	Boolean isValid = false;
		while (!isValid) {
			s = getString(prompt);
			if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2) && !s.equalsIgnoreCase(s3)) {
				System.out.println("\nError! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			} else {
				isValid = true;
				System.out.println();
			}
		}
		return s;
	}	
}
