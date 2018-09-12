package nchecker;

import java.util.Scanner;

public class MyConsole extends Console {
	private static Scanner sc = new Scanner(System.in);
	
	public MyConsole() {
		super();
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
				System.out.println("\nError! Must enter a value. Try again.");
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
				System.out.println("\nError! Entry must be '" + s1 + "' or '" + s2 + "'. Try again....");
			} else {
				isValid = true;
				System.out.println();
			}
		}
		return s;
	}	
}
