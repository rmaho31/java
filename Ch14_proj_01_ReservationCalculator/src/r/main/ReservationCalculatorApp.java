package r.main;

import r.business.Reservation;
import r.utility.Console;

public class ReservationCalculatorApp {

	public static void main(String[] args) {
		Console.println("Welcome to The Reservation Calculator");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			Reservation r = makeReservation();
			printReservation(r);
			choice = Console.getString("Continue? (y/n): ", "y", "n");			
		}
	}
	
	public static Reservation makeReservation() {
		return new Reservation(Console.getString("Enter Arrival Date: YYYY-MM-DD: ", "\\d+-\\d+-\\d+"),
							   Console.getString("Enter Departure Date: YYYY-MM-DD: ", "\\d+-\\d+-\\d+"));
	}
	public static void printReservation(Reservation r) {
		Console.println("Arrival Date: " + r.getDateArrivalFormatted() +
						"\nDeparture Date: " + r.getDateDepartureFormatted() + 
						"\nPrice: " + r.getNIGHTLY_RATE() + "Total price: " + r.getTotalPrice()+ "\n");
		
	}

}
