package tempconvert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class TemperatureConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Temperature Converter\n");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			//grab input from user and apply the conversion formula			
			System.out.print("Enter degrees in Fahrenheit: ");
			
			double f = sc.nextDouble();
			BigDecimal c = new BigDecimal((f-32)*5/9);
			
			System.out.println("Degrees in Celsius: " + c.setScale(2, RoundingMode.HALF_UP));
			
			System.out.print("\nContinue? (y/n): ");
			choice = sc.next();
			
			System.out.println();
			
		}
		sc.close();
	}

}
