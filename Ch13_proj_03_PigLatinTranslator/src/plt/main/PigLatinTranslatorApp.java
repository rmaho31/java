package plt.main;

import plt.utility.Console;

public class PigLatinTranslatorApp {

	public static void main(String[] args) {
		Console.println("Pig Latin Translator");
		
		String line = Console.getString("Enter a line: ");
		
		String pigLatin = translatePigLatin(line);
		
		Console.print(pigLatin);
	}
	
	public static String translatePigLatin(String line) {
		String[] words = line.split(" ");
		String pigLatin = "";
		for(int i = 0; i < words.length; i++) {
			words[i] = words[i].toLowerCase();
			if(!words[i].matches(".*[\\d@$#].*")) {
				words[i] = words[i].replaceAll("[\\.,:;!\"]+$", "");
				if(words[i].matches("^[aeiou].*")) {
					words[i] = words[i] + "way";
				} else {
					String begin = words[i].replaceAll("^[^aeiou][^aeiouy]*", "");
					String end = words[i].substring(0, words[i].length() - begin.length());
					words[i] = begin + end + "ay";
				}			
			pigLatin += words[i] + " ";
			}
		}
		return pigLatin;
	}

}
