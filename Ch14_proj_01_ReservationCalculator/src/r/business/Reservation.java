package r.business;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Reservation {
	private LocalDate dateArrival;
	private LocalDate dateDeparture;
	private final double NIGHTLY_RATE = 145.00;
	
	public Reservation(String dArr, String dDep) {
		this.dateArrival = LocalDate.parse(dArr);
		this.dateDeparture = LocalDate.parse(dDep);
	}
	
	public LocalDate getDateArrival() {
		return dateArrival;
	}
	public String getDateArrivalFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		return dtf.format(dateArrival);
	}
	public void setDateArrival(LocalDate dateArrival) {
		this.dateArrival = dateArrival;
	}
	public LocalDate getDateDeparture() {
		return dateDeparture;
	}
	public String getDateDepartureFormatted() {
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		return dtf.format(dateDeparture);
	}
	public void setDateDeparture(LocalDate dateDeparture) {
		this.dateDeparture = dateDeparture;
	}
	public int getNights() {
		return Period.between(dateArrival, dateDeparture).getDays();
	}

	public String getNIGHTLY_RATE() {
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		return cf.format(NIGHTLY_RATE);
	}
	
	public String getTotalPrice() {
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		return cf.format(NIGHTLY_RATE*getNights());
	}
	
	
	
}
