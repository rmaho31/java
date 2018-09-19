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
		//splits the string into an array of space
		String[] words = line.split(" ");
		//declare to use as final string
		String pigLatin = "";
		for(int i = 0; i < words.length; i++) {
			//***specification lower case each word and store it over itself
			words[i] = words[i].toLowerCase();
			//***specification if word matches 0-9 or @ or $ or # anywhere then don't change it
			if(!words[i].matches(".*[\\d@$#].*")) {
				//***specification if word has punctuation at the end 1 or more times replace with empty char
				words[i] = words[i].replaceAll("[\\.,:;?!\"]+$", "");
				//***specification checks if the word starts with a vowel and adds way to the end if it does
				if(words[i].matches("^[aeiou].*")) {
					words[i] = words[i] + "way";
				} else {
					//***specification if word starts with a consonant replace all the 
					//consonants until you hit a vowel or y with empty char
					String begin = words[i].replaceAll("^[^aeiou][^aeiouy]*", "");
					//subtract the length of the replaced string from the word length to 
					//get the consonants removed from the beginning to add them at the end
					String end = words[i].substring(0, words[i].length() - begin.length());
					//concatenate the string together for the word
					words[i] = begin + end + "ay";
				}
			//concatenate the words back into a sentence
			pigLatin += words[i] + " ";
			}
		}
		//return translated sentence
		return pigLatin;
	}

}
