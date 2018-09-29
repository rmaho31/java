package pc.main;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import pc.utility.Console;

public class PathCheckerApp {

	public static void main(String[] args) {
		Console.println("Path Checker");
		
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			Path path = Paths.get(Console.getString("Enter Path: "));
			File f = path.toFile();
			System.out.println(f.getAbsolutePath());
			
			if(f.isFile()) {
				Console.println("The path points to a file.");
			} else if(f.isDirectory()) {
				Console.println("Path points to a directory.");
			} else {
				Console.println("The path does not exist.");
			}
			
			choice = Console.getString("Continue? (y/n): ", "y", "n");
		}
	}
}
