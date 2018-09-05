package fstats;

public class Player {
	private static String name;
	private static int age;
	private static String position;
	private static int yearsPro;
	
	public static String getName() {
		return name;
	}
	
	public static int getAge() {
		return age;
	}
	
	public static String getPosition() {
		return position;
	}
	
	public static int getYearsPro() {
		return yearsPro;
	}
	
	public static void setName(String x) {
		name = x;
	}
	
	public static void setAge(int x) {
		age = x;
	}
	
	public static void setPosition(String x) {
		position = x;
	}
	
	public static void setYearsPro(int x) {
		yearsPro = x;
	}	
}
