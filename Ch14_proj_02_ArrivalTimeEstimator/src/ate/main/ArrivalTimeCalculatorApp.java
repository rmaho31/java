package ate.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

import ate.business.TravelTime;
import ate.utility.Console;

public class ArrivalTimeCalculatorApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Travel Time Calculator\n");
		
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			TravelTime tt = new TravelTime(Console.getInt("Enter miles: ", 0, Integer.MAX_VALUE),
										   Console.getInt("Enter miles per hour: ", 0, Integer.MAX_VALUE));
			
			String datetime = Console.getString("Departure date (YYYY-MM-DD): ");
			datetime += "T" + Console.getString("Enter time: (hh:mm): ");
			LocalDateTime dd = LocalDateTime.parse(datetime);
			
			dd = dd.plusMinutes(tt.getMinutes());
			dd = dd.plusHours(tt.getHours());
			DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
			DateTimeFormatter dtm = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
			System.out.println("\nEstimated Travel Time\n"
							 +   "---------------------");
			System.out.println("Hours: " + tt.getHours());
			System.out.println("Minutes: " + tt.getMinutes());
			System.out.println("Estimated date of arrival: " + dtf.format(dd.toLocalDate()));
			System.out.println("Estimated time of arrival: " + dtm.format(dd.toLocalTime()));
			choice = Console.getString("\nContinue? (y/n): ", "y", "n");
			
		}
		sc.close();

	}

}
