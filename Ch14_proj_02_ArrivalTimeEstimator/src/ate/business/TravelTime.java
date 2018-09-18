package ate.business;

public class TravelTime {
	int hours;
	int minutes;
	int milesrem;
	
	public TravelTime(int miles, int mph) {
		hours = miles / mph;
		milesrem = miles % mph;
		minutes = (milesrem / (mph/60));
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getMilesrem() {
		return milesrem;
	}

	public void setMilesrem(int milesrem) {
		this.milesrem = milesrem;
	}
	
}
