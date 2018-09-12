package ctest;

import java.util.Scanner;

public class ConsoleIO implements UserIO {
	Scanner sc;
	
	public ConsoleIO() {
		this.sc = new Scanner(System.in);
	}

	@Override
	public int getInt(String prompt) {
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

	@Override
	public int getInt(String prompt, int min, int max) {
		int i = 0;
        boolean isValid = false;
        while (!isValid) {
            i = getInt(prompt);
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

	@Override
	public double getDouble(String prompt) {
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

	@Override
	public double getDouble(String prompt, double min, double max) {
		double d = 0.0;
        boolean isValid = false;
        while (!isValid) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "\nError! Number must be greater than " + min + ".\n");
            } else if (d >= max) {
                System.out.println(
                        "\nError! Number must be less than " + max + ".\n");
            } else {
                isValid = true;
            }
        }
        return d;
	}

	@Override
	public String getString(String prompt) {
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

	@Override
	public String getString(String prompt, String s1, String s2) {
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

	@Override
	public void print(String s) {
		System.out.print(s);		
	}

	@Override
	public void println() {
		System.out.println();
	}

	@Override
	public void println(String s) {
		System.out.println(s);
	}
}
