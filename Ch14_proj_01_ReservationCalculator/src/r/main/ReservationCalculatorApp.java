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
			choice = Console.getString("Continue? (y/n)", "y", "n");
			
		}

	}
	
	public static Reservation makeReservation() {
		String[] dArr = Console.getString("Enter Arrival Date: MM/DD/YYYY: ", "\\d+/\\d+/\\d+").split("/");
		String[] dDep = Console.getString("Enter Departure Date: MM/DD/YYYY: ", "\\d+/\\d+/\\d+").split("/");
		
		Reservation r = new Reservation(dArr[2] + "-" + dArr[0] + "-" + dArr[1],
										dDep[2] + "-" + dDep[0] + "-" + dDep[1]);
		return r;
	}
	public static void printReservation(Reservation r) {
		Console.println("Arrival Date: " + r.getDateArrivalFormatted());
		Console.println("Departure Date: " + r.getDateDepartureFormatted());
		Console.println("Price: " + r.getNIGHTLY_RATE());
		Console.println("Total price: " + r.getTotalPrice()+ "\n");
		
	}

}
