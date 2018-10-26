package mr.business;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MovieCollection {
	private List<Movie> movies;
	
	public MovieCollection() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie("Avengers Infinity War", 2018, 4.0));
		movies.add(new Movie("Star Wars Episode 5 - Empire Strikes Back", 1980, 5.0));
		movies.add(new Movie("Sixteen Candles", 1984, 4.5));
		movies.add(new Movie("Happy Gilmore", 1996, 4.3));
		movies.add(new Movie("The Jerk", 1979, 3.9));
		movies.add(new Movie("Superbad", 2007, 3.9));
		movies.add(new Movie("Back to the Future Part III", 1990, 2.1));
		movies.add(new Movie("Entourage", 2015, 1.5));
	}
	
	public void add(Movie movie) {	
		movies.add(movie);
	}
	
	public List<Movie> filterMovies(Predicate<Movie> condition){
		return movies.stream().filter(condition).collect(Collectors.toList());
	}
	public double getLowestRating() {
		return movies.stream().mapToDouble(x -> x.getRating()).min().getAsDouble();
	}
	public double getHighestRating() {
		return movies.stream().mapToDouble(x -> x.getRating()).max().getAsDouble();
	}
	public double getAverageRating() {
		return movies.stream().mapToDouble(x -> x.getRating()).average().getAsDouble();
	}
	public int getSize() {
		return movies.size();
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public DoubleSummaryStatistics summaryStatistics() {
		return movies.stream().collect(Collectors.summarizingDouble(Movie::getRating));
	}
		      
	

}
