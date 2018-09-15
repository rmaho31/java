package clist;

public class ContactListApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Contact List Application!\n");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String fname = Console.getString("Enter first name: ");
			String lname = Console.getString("Enter last name: ");
			String email = Console.getString("Enter e-mail: ");
			String phoneNum = Console.getString("Enter phone: ");
			
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
			System.out.println("---------------------------------------------");
			
			//checks for y or n
			choice = Console.getString("\nContinue (y/n): ", "y", "n");
			System.out.println();
		}
	}

}
