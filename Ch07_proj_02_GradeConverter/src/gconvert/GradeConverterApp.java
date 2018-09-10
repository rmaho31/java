package gconvert;

import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Grade Converter App!\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			Grade grade = new Grade(Console.getInt(sc, "Enter numerical grade: ", 0, 100));
			
			System.out.println("Letter grade: " + grade.getLetter());
			
			choice = Console.getString(sc, "\nContinue (y/n): ", "y", "n");
		}
		
		

	}

}
