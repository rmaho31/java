package plt.main;

import plt.utility.Console;

public class PigLatinTranslatorApp {

	public static void main(String[] args) {
		Console.println("Pig Latin Translator");
		
		String line = Console.getString("Enter a line: ");
		
		String[] words = line.split(" ");
		String pigLatin = "";
		for(int i = 0; i < words.length; i++) {
			pigLatin += translatePigLatin(words[i]) + " ";
		}
		
		Console.print(pigLatin);
	}
	
	public static String translatePigLatin(String word) {
		if(!word.matches(".*[\\d@$#].*")) {
			word = word.toLowerCase();
			word = word.replaceAll("[\\.,!\"]$", "");
			if(word.matches("^[aeiou].*")) {
				word = word + "way";
			} else {
				String begin = word.replaceAll("^[^aeiou][^aeiouy]*", "");
				String end = word.substring(0, word.length() - begin.length());
				word = begin + end + "ay";
			}			
		}
		return word;
	}
}
