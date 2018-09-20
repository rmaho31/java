package fc.main;

import fc.db.FileCleanerIO;
import fc.utility.Console;

public class FileCleanerApp {
	private static FileCleanerIO userFile = new FileCleanerIO();
	public static void main(String[] args) {
		Console.println("File Cleaner");
		
		userFile.getAll();
		Console.println("\nSource file: " + userFile.getUsersFile().getName());
		
		userFile.cleanSave();
		Console.println("Cleaned file: " + userFile.getUsersFile().getName());
		
		Console.println("\nCongratulations! Your file has been cleaned!");
	}

}
