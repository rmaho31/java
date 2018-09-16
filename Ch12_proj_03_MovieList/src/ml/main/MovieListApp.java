package ml.main;

import java.util.ArrayList;
import java.util.Collections;

import ml.business.Movie;
import ml.db.MovieIO;
import ml.utility.Console;

public class MovieListApp {

	public static void main(String[] args) {
		Console.println("The Movie List Application\n");
		
		ArrayList<Movie> ml = generateMovieArray();
		Console.println("Choose from " + ml.size() + " movies");
		
		ArrayList<String> cats = uniqueCategories(ml);
		printCategories(cats);		
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			int selection = Console.getInt("Enter category number: ", 0, cats.size() + 1) - 1;
			
			displayCategoryMatches(selection, ml, cats);
			
			choice = Console.getString("Another category? (y/n): ", "y", "n");
		}
		
		Console.println("Bye!");

	}
	
	public static ArrayList<Movie> generateMovieArray() {
		//pull moviesIO objects into list
				ArrayList<Movie> ml = new ArrayList<>();
				for(int i = 1; i <= 100; i++) {
					ml.add(MovieIO.getMovie(i));
				}
				return ml;
	}
	
	public static ArrayList<String> uniqueCategories(ArrayList<Movie> ml) {
		ArrayList<String> cats = new ArrayList<>();
		for(Movie m : ml) {
			if(!cats.contains(m.getCategory())){
				cats.add(m.getCategory());
			}
		}
		return cats;
	}
	
	public static void printCategories(ArrayList<String> cats) {
		Console.println();
		for(int j = 0; j < cats.size(); j++) {
			Console.println((j + 1) + ". " + cats.get(j));
		}
		Console.println();
	}
	
	public static void displayCategoryMatches(int selection, ArrayList<Movie> ml, ArrayList<String> cats) {
		ArrayList<String> matches = new ArrayList<>();
		for(Movie m : ml) {
			if(m.getCategory().equalsIgnoreCase(cats.get(selection))) {
				matches.add(m.getTitle());
			}
		}
		Collections.sort(matches);
		Console.println();
		for(String title : matches) {
			Console.println(title);			
		}
		Console.println();
	}

}
