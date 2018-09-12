package gradeconverter;

import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y" ;
		while (choice.equalsIgnoreCase("y"))
		{
			int grade = getIntWithinRange(sc, "Enter numerical grade: ", 0, 100);
			String letter;
			
			if (grade >= 88 && grade <= 100)
				letter = "A"; 	
			else if (grade >= 80)
				letter = "B";
			else if (grade >=67)
				letter = "C";
			else if (grade >= 60)
				letter = "D";
			else if (grade <= 59)
				letter = "F";
			else 
				letter = "Not a Valid grade range!";
			
			System.out.println("Letter grade: " + letter);
			
			choice = yOrNo(sc, "\nContinue? (y/n): ");
		}
		sc.close();
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
	
	public static int getIntWithinRange(Scanner sc, String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
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
}
