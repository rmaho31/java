package clist;

import java.util.Scanner;

public class ContactListApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact List Application!\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String fname = Console.getString(sc, "Enter first name: ");
			String lname = Console.getString(sc, "Enter last name: ");
			String email = Console.getString(sc, "Enter e-mail: ");
			String phoneNum = Console.getString(sc, "Enter phone: ");
			
			Contact.setFname(fname);
			Contact.setLname(lname);
			Contact.setEmail(email);
			Contact.setPhoneNum(phoneNum);
			
			System.out.println("\n---------------------------------------------\n" +
							   "---- Current Contact ------------------------\n" +
							   "---------------------------------------------");
			System.out.println("Name:\t\t" + Contact.getFname() + " " + Contact.getLname());
			System.out.println("Email Address:\t" + Contact.getEmail());
			System.out.println("Phone Number:\t" + Contact.getPhoneNum());
			System.out.println("---------------------------------------------\n");
			
			//checks for y or n
			choice = Console.getString(sc, "Continue (y/n): ", choice);
			System.out.println();
		}
		

	}

}
