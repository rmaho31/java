package sw.main;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class StopWatchApp {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Let's see how fast you are!!!!!!");
		LocalDateTime lsart = getTime("Enter Start: ", "start");
		LocalDateTime lstop = getTime("Enter Stop: ", "stop");
		Long time = ChronoUnit.NANOS.between(lsart, lstop);
		Long seconds = time/1000000000;
		Long nanos = time % 1000000000;
		System.out.println(seconds + ":" + nanos + " Seconds");
	}
	
	public static LocalDateTime getTime(String s, String s1) {
		String string = getString(s);
		if(!string.equalsIgnoreCase(s1)) {
			getTime(s,s1);
		}
		return LocalDateTime.now();
	}
	
	public static String getString(String s) {
		System.out.print(s);
		String string = sc.nextLine();
		if(string.equals("")) {
			getString(s);
		}
		System.out.println();
		return string;
	}
}
