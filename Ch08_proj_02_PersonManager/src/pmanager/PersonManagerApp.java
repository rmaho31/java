package pmanager;

public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager!\n");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			String input1 = Console.getString("Create customer or employee? (c/e)", "c", "e");
			
			if(input1.equalsIgnoreCase("c")) {
				String fName = Console.getString("First name: ");
				String lName = Console.getString("Last name: ");
				String number = Console.getString("Customer number: ");
				
				Customer c1 = new Customer(fName, lName, number);
				
				System.out.println("\nYou entered a new customer: ");
				System.out.println(c1.toString());
			} else if (input1.equalsIgnoreCase("e")) {
				String fName = Console.getString("First name: ");
				String lName = Console.getString("Last name: ");
				String ssn = Console.getString("SSN number: ");
				
				Employee e1 = new Employee(fName, lName, ssn);
				
				System.out.println("\nYou entered a new customer: ");
				System.out.println(e1.toString());
			}
			
			choice = Console.getString("\nContinue? (y/n)", "y", "n");
		}
	}
}
