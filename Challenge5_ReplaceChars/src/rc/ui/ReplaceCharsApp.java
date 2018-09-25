package rc.ui;

import rc.utility.Console;

public class ReplaceCharsApp {

	public static void main(String[] args) {
		String s = Console.getString("Enter Line to be converted: ");
		Console.println(s.replaceAll("[aeiouAEIOU]", "_"));

	}

}
