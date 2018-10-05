package pd.main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;

import pd.function.Dice;
import pd.util.Console;

public class DiceRollApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Dice Roller!");
		
		
		
		
		
		double choice = 0;
		choice = Console.getDouble("Number of rolls?: ", 0, Double.POSITIVE_INFINITY);
		
		runGame(choice);
		
	}
	
	public static void runGame(double choice) {
		int rolls = 0;
		int total = 0;
		double percTwo = 0;
		double percThree = 0;
		double percFour = 0;
		double percFive = 0;
		double percSix = 0;
		
		for(double i = 0; i < choice; i++) {
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
			

			rolls = Math.max(rolls, counter);
			total = Math.max(total, sum);
			percTwo = Math.max(percTwo, two/(double) counter);
			percThree = Math.max(percThree, three/(double)counter);
			percFour = Math.max(percFour, four/(double)counter);
			percFive = Math.max(percFive, five/(double)counter);
			percSix = Math.max(percSix, six/(double)counter);
			
		}

		
		double[] n1 = {percTwo, percThree,
					   percFour, percFive,
					   percSix}; 

		
		System.out.println("Played " + choice + " games");
		System.out.println("Highest Score was " + total);
		System.out.println("Highest number of rolls was " + rolls);
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


