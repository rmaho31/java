package StudentRegistration;

import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		System.out.println("Student Registration Form\n");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter first name: ");
		String fname = sc.next();
		System.out.print("Enter last name: ");
		String lname = sc.next();
		System.out.print("Enter year of birth: ");
		int year = sc.nextInt();
		
		System.out.println("\nWelcome " + fname + " " + lname + "!");
		System.out.println("Your Registration is complete.");
		System.out.println("Your temporary password is: " + fname + "*" + year);
		sc.close();

	}

}
