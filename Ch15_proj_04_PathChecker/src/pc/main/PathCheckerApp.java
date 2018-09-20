package pc.main;

import java.io.File;

import pc.utility.Console;

public class PathCheckerApp {

	public static void main(String[] args) {
		Console.println("Path Checker");
		
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			File file = new File(Console.getString("Enter a path: "));
			
			System.out.println(file.getAbsolutePath());

			if(file.exists() && file.isFile()) {
				Console.println("The path points to a file.");
			} else if(file.exists() && file.isDirectory()) {
				Console.println("Path points to a directory.");
			} else {
				Console.println("The path does not exist.");
			}
			
			choice = Console.getString("Continue? (y/n)", "y", "n");
		}

	}

}
