package sm.ui;

import sm.utility.Console;

public class StringMatchApp {

	public static void main(String[] args) {
		Console.println(match2("xxcaazz", "xxbaaz") + "");
		Console.println(match2("abc", "abc") + "");
		Console.println(match2("abc", "axc") + "");

	}
	
	public static int match2(String s1, String s2) {
		int x = 0;
		for(int i = 0; i < s2.length()-1; i++) {
			if(s1.matches((".*"+s2.substring(i, i+2)+".*"))) {
				x += 1;
			}
		}
		return x;
	}
}
