package wi.main;

import java.util.ArrayList;

import wi.business.Inventory;
import wi.utility.Console;

public class WizardInventoryApp {

	public static void main(String[] args) {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("show");
		commands.add("grab");
		commands.add("edit");
		commands.add("drop");
		commands.add("exit");
		
		Console.println("Welcome to the Wizard Invecntory");
		
		Console.println("\nCOMMAND MENU");
		Console.println("show - Show all items");
		Console.println("grab - Grab(add) an item");
		Console.println("edit - Edit an item");
		Console.println("drop - Drop an item");
		Console.println("exit - Exit program\n");
		
		Inventory i = new Inventory();
		
		String choice = "";
		while(!choice.equals("exit")) {
			
			String cmd = Console.getString("Command: ", commands);
			
			
			if(cmd.equalsIgnoreCase("show")) {
				Console.println(i.toString());
			} else if(cmd.equalsIgnoreCase("grab")) {
				if(i.getInventory().size() < 4) {
					String name = Console.getString("Name: ");
					i.addItem(name);
				} else {
					Console.println("You can't carry any more items. Drop something first");
				}
			} else if(cmd.equalsIgnoreCase("edit")) {
				if(i.getInventory().size() > 0) {
					int index = Console.getInt("Number: ", -1, i.getInventory().size());
					String item = Console.getString("Updated name: ");
					i.editItem(index, item);
				} else {
					Console.println("You must add items to the Inventory first!");					
				}
			} else if(cmd.equalsIgnoreCase("drop")) {
				if(i.getInventory().size() > 0) {
					int index = Console.getInt("Number: ", -1, i.getInventory().size());
					i.deleteItem(index);
				} else {
					Console.println("You must add items to the Inventory first!");
				}
			} else if(cmd.equalsIgnoreCase("exit")) {
				choice = "exit";
			}
		}
	}
}
