package clm.main;

import clm.db.CountryIO;
import clm.utility.Console;

public class CountryListManagerApp {

	public static void main(String[] args) {
		Console.println("Country List Manager\n");
		
		
		
		int choice = 0;
		while (choice != 4) {
			printCommandMenu();
			CountryIO cio = new CountryIO();
			choice = Console.getInt("Enter menu number: ", 0, 5);
			
			if(choice == 1) {
				System.out.println();
				for(String s : cio.getAll()) {
					System.out.println(s);
				}
			} else if (choice == 2) {
				cio.add(Console.getString("Enter country: "));
			} else if (choice == 3) {
				cio.delete(Console.getString("Enter country: "));
			}
		}
		

	}
	
	public static void printCommandMenu() {
		Console.println("COMMAND MENU");
		Console.println("1 - List countries");
		Console.println("2 - Add a country");
		Console.println("3 - Delete a country");
		Console.println("4 - Exit");
	}

}
