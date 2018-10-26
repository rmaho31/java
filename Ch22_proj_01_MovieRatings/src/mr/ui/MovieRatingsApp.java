package mr.ui;

import java.time.LocalDate;

import mr.business.Movie;
import mr.business.MovieCollection;
import mr.utility.Console;

public class MovieRatingsApp {

	public static void main(String[] args) {
		MovieCollection mc = new MovieCollection();
		int command = 0;
		while(command != 6) {
			displayMenu();
			command = Console.getInt("Enter Command: ", 0, 7);
			if(command == 1) {
				int nbr = Console.getInt("How many movies to enter: ");
				add(mc, nbr);
			} else if(command == 2) {
				viewTopR(mc);
			} else if(command == 3) {
				viewMostRecent(mc);
			} else if(command == 4) {
				viewMovies(mc);
			} else if(command == 5) {
				viewRatings(mc);
			}
		}

	}


	private static void displayMenu() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nCOMMAND MENU\n");
		sb.append("1 - Enter a movie\n");
		sb.append("2 - View top rated movies\n");
		sb.append("3 - View most recent movies\n");
		sb.append("4 - View all movies\n");
		sb.append("5 - View ratings\n");
		sb.append("6 - Quit program\n");
		System.out.println(sb);
	}
	
	private static void add(MovieCollection mc, int nbr) {
		for(int x = 1; x <= nbr; x++) {
			Console.println("Movie Number # "+ x);
			Console.println("===============");
			mc.add(new Movie(Console.getString("Enter movie name: "), Console.getInt("Enter year: "), Console.getDouble("Enter rating: ", .9999999, 5.00001)));
		}
	}
	
	private static void viewTopR(MovieCollection mc) {
		Console.println("Movies Rating >= 4.0");
		Console.println("====================");	
		mc.getMovies().stream().filter(x -> x.getRating() >= 4.0).forEach(System.out::println);
	}
	private static void viewMostRecent(MovieCollection mc) {
		Console.println("Movies Year >= 2008");
		Console.println("====================");
		mc.getMovies().stream().filter(x -> x.getYear() >= (LocalDate.now().getYear()-10)).forEach(System.out::println);
	}
	private static void viewMovies(MovieCollection mc) {
		Console.println("All Movies");
		Console.println("==========");
		mc.getMovies().stream().forEach(System.out::println);
	}
	private static void viewRatings(MovieCollection mc) {
		Console.println("Movies Ratings");
		Console.println("==============");
		Console.println("Count: " + mc.summaryStatistics().getCount()+"");
		Console.println("Min Rating: " + mc.summaryStatistics().getMin()+"");
		Console.println("Max Rating: " + mc.summaryStatistics().getMax()+"");
		Console.println("Average Rating: " + mc.summaryStatistics().getAverage()+"");
	}
	
	
}
