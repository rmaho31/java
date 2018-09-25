package sb.ui;

import sb.utility.Console;

public class StringBitsApp {

	public static void main(String[] args) {
		String s = "Hello";
		Console.println(replaceEveryOther(s));

	}
	
	public static String replaceEveryOther(String s) {
		String modified = "";
		for(int i = 0; i < s.length(); i += 2) {
			modified += s.charAt(i);
		}
		return modified;
	}

}
