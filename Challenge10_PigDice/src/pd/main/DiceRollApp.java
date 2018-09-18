package pd.main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

import pd.function.Dice;
import pd.util.Console;

public class DiceRollApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller!");
		
		
		
		
		
		int choice = 0;
		choice = Console.getInt("Number of rolls?: ", 0, Integer.MAX_VALUE);
		
		runGame(choice);
		
	}
	
	public static void runGame(int choice) {
		ArrayList<Integer> rolls = new ArrayList<>();
		ArrayList<Integer> total = new ArrayList<>();
		ArrayList<Double> percTwo = new ArrayList<>();
		ArrayList<Double> percThree = new ArrayList<>();
		ArrayList<Double> percFour = new ArrayList<>();
		ArrayList<Double> percFive = new ArrayList<>();
		ArrayList<Double> percSix = new ArrayList<>();
		
		for(int i = 0; i < choice; i++) {
			int two = 0;
			int three = 0;
			int four = 0;
			int five = 0;
			int six = 0;
			int sum = 0;
			int d1 = 0;
			int counter = 0;
			
			while(d1 == 0) {
				Dice dice = new Dice();
				dice.roll();
				
				if(dice.getDie1Value() == 2) {
					two++;
				} else if(dice.getDie1Value() == 3) {
					three++;
				} else if(dice.getDie1Value() == 4) {
					four++;
				} else if(dice.getDie1Value() == 5) {
					five++;
				} else if(dice.getDie1Value() == 6) {
					six++;
				} else {
					d1++;
				}
				counter++;
				sum += dice.getDie1Value();
			}
			

			rolls.add(counter);
			total.add(sum);
			percTwo.add((double)two/(double)counter);
			percThree.add((double)three/(double)counter);
			percFour.add((double)four/(double)counter);
			percFive.add((double)five/(double)counter);
			percSix.add((double)six/(double)counter);
			
		}
		Collections.sort(rolls);
		Collections.sort(total);
		Collections.sort(percTwo);
		Collections.sort(percThree);
		Collections.sort(percFour);
		Collections.sort(percFive);
		Collections.sort(percSix);
		
		double[] n1 = {percTwo.get(percTwo.size()-1), percThree.get(percThree.size()-1),
					   percFour.get(percFour.size()-1), percFive.get(percFive.size()-1),
					   percSix.get(percSix.size()-1)}; 

		
		System.out.println("Played " + choice + " games");
		System.out.println("Highest Score was " + total.get(total.size()-1));
		System.out.println("Highest number of rolls was " + rolls.get(rolls.size()-1));
		System.out.println(getHighestPercent(n1));
		System.out.println("\nBye!");
	}
	
	public static String getHighestPercent(double[] n1) {
		NumberFormat pf = NumberFormat.getPercentInstance();
		int maxNum = 0;
		double max = n1[0];
		for(int i = 1; i < 5; i++) {
			if(n1[i] > max) {
				maxNum = i;
			}
			max = Math.max(max, n1[i]);
		}
		return "The highest percent of total rolls was " + pf.format(max) + " " + (maxNum+2) + "'s"; 
	}

}


