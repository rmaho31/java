package lc.main;

import java.util.List;

import lc.utility.Console;
import lc.utility.ConversionIO;
import sc.db.Conversion;

public class LengthConverterApp {
	private static final ConversionIO FILE = new ConversionIO();
	public static void main(String[] args) {
				
		
		int choice = 0;
		while(choice != 4) {
			printCommands();
			choice = Console.getInt("Enter menu number: ", 0, 5);
			
			if(choice == 1) {
				if(FILE.getAll().size() < 1) {
					Console.println("Must add conversions first!\n");
				} else {
					printArrayObjects();
					performConversionPrintResults();					
				}
			} else if(choice == 2) {
				addObject();
			} else if(choice == 3) {
				printArrayObjects();
				deleteObject();
			}
		}

	}
	
	public static void printCommands() {
		Console.println("Length Converter");
		Console.println("1 - Convert a length");
		Console.println("2 - Add a type of conversion");
		Console.println("3 - Delete a type of conversion");
		Console.println("4 - exit\n");
	}
	
	public static void printArrayObjects() {
		List<Conversion> c = FILE.getAll();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < c.size(); i++) {
			sb.append((i+1) + " - " + c.get(i).getFromUnit() + " to ");
			sb.append(c.get(i).getToUnit() + ":");
			sb.append(" " + c.get(i).getConversionValue());
			sb.append("\n");
		}
		Console.println(sb + "");
	}
	
	public static void performConversionPrintResults() {
		Conversion c = FILE.get(Console.getInt("Enter conversion number: ", -1, FILE.getAll().size() + 1) - 1);
		double n1 = Console.getDouble("Enter " + c.getFromUnit() + ":");
		double val = c.convertValue(n1);
		
		Console.println(n1 + " " + c.getFromUnit() + " = " + val + " " + c.getToUnit());
		Console.println();
	}
	public static void addObject() {
		Conversion c = new Conversion(Console.getString("Enter 'from' unit: "), 
									  Console.getString("Enter 'to' unit: "),
									  Console.getDouble("Enter the conversion ration: "));
		FILE.add(c);
		
		Console.println("Conversion added");
	}
	
	public static void deleteObject() {
		Conversion c = FILE.get(Console.getInt("Enter conversion number to delete: ", -1, FILE.getAll().size()));
		FILE.delete(c);
		Console.println("Conversion has been successfully deleted");
	}
}
