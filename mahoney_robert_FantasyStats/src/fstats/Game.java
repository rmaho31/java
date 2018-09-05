package fstats;

public class Game {
	private static int year;
	private static String opponent;
	private static String date;
	private static String weather;
	private static String location;
	
	public static int getYear() {
		return year;
	}
	
	public static String getOpponent( ) {
		return opponent;
	}
	
	public static String getDate() {
		return date;
	}
	
	public static String getWeather() {
		return weather;
	}
	
	public static String getLocation() {
		return location;
	}
	
	public static void setYear(int x) {
		year = x;
	}
	
	public static void setOpponent(String x) {
		opponent = x;
	}
	
	public static void setDate(String x) {
		date = x;
	}
	
	public static void setWeather(String x) {
		weather = x;
	}
	
	public static void setLocation(String x) {
		location = x;
	}
}

