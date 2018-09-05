package gradeconverter;

import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Letter Grade Converter\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y" ;
		while (choice.equalsIgnoreCase("y"))
		{
			System.out.print("Enter numerical grade: ");
			int grade = sc.nextInt();
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
			
			System.out.println("Letter grade: " + letter + "\n");
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		sc.close();
	}
}
