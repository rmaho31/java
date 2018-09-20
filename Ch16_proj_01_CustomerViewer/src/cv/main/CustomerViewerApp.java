package cv.main;

import cv.utility.Console;
import murach.business.Customer;
import murach.business.NoSuchCustomerException;
import murach.db.CustomerDB;

public class CustomerViewerApp {

	public static void main(String[] args) {
		Console.println("Customer Viewer");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			Customer n = null;
			try {
				n = CustomerDB.getCustomer(Console.getInt("Enter number: "));
			} catch (NoSuchCustomerException e) {
				
				System.out.println(e.getMessage());
				continue;
			}
			
			Console.println(n.getAddress());
			choice = Console.getString("Display another customer? (y/n)", "y", "n");
		}

	}

}
