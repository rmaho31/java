package gconvert;

public class GradeConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Grade Converter App!");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			Grade grade = new Grade(Console.getInt("\nEnter numerical grade: ", 0, 100));
			
			System.out.println("Letter grade: " + grade.getLetter());
			
			choice = Console.getString("\nContinue (y/n): ", "y", "n");
		}
	}

}
