package gradeconverter;

import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter\n");
		
		// create a Scanner object named sc
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String choice = "y" ;
		while (choice.equalsIgnoreCase("y"))
		{
			System.out.print("Enter numerical grade: ");
			int grade = sc.nextInt();
			String letter;
			
			if (grade >= 88 && grade <= 100) {
				letter = "A"; 	
			} else if (grade <= 87 & grade >= 80) {
				letter = "B";
			} else if (grade <= 79 && grade >=67) {
				letter = "C";
			} else if (grade <= 66 && grade >= 60) {
				letter = "D";
			} else if (grade <= 59) {
				letter = "F";
			} else {
				letter = "Not a Valid grade range!";
			}
			System.out.println("Letter grade: " + letter + "\n");
			System.out.println("Continue? (y/n)");
			choice = sc.next();
			System.out.println();
		}
	}
}
