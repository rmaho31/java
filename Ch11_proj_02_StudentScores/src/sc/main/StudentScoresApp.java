package sc.main;

import java.util.Arrays;

import sc.business.Student;

public class StudentScoresApp {

	public static void main(String[] args) {
		Console.println("Welcome to the Student Scores Application");
		
		Student[] s1 = new Student[Console.getInt("\nNumber of Students: ", -1, Integer.MAX_VALUE)];
		
		for(int i = 0; i < s1.length; i++) {
			Console.println(Integer.toString(i + 1 ));
			s1[i] = new Student(Console.getString("\n"
					+ "Last name: "),
								Console.getString("First name: "), 
								Console.getInt("Enter score: ", -1, 101));
		}
		
		Console.println("\nSUMMARY");
		Arrays.sort(s1);
		for(int j = 0; j < s1.length; j++) {
			Console.println(s1[j].toString());
		}
	}
}
