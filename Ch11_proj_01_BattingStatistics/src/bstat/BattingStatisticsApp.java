package bstat;

import java.text.NumberFormat;

public class BattingStatisticsApp {

	public static void main(String[] args) {
		Console.println("Welcome to the Batting Average Calculator!");
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMinimumFractionDigits(3);
		
		int num =Console.getInt("Enter number of times at bat: ", -1, Integer.MAX_VALUE);
		Console.println();
		int[] atBats = new int[num];
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			Console.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run/n");
			
			for (int i = 0; i < atBats.length; i++) {
				atBats[i] = Console.getInt("Result for at bat " + i + ": ", -1, 4);
			}
			
			int sum = 0;
			int sum2 = 0;
			for (int hits : atBats) {
				if(hits > 0) {
					sum++;
				}
				sum2 += hits;
			}
			Console.println("\nBatting average: " + nf.format((double)sum/(double)atBats.length));
			Console.println("Slugging percent: " + nf.format((double)sum2/(double)atBats.length));
			
			choice = Console.getString("Another Player? (y/n): ", "y", "n");
		}
		
		
		

	}

}
