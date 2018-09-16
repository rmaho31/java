package pnc.business;

import java.util.ArrayList;

public class PrimeNumberCalc {
	private int number;
	private ArrayList<Integer> factors = new ArrayList<Integer>();
	
	public PrimeNumberCalc(int number) {
		this.number = number;
	}
	
	public ArrayList<Integer> returnFactors() {
		
		for(int i = 1; i <= number; i++) {
			if(number % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
	
	public boolean checkPrime() {
		if(number == 1) {
			return true;
		}
		int counter = 0;
		for(int i = 1; i <= number; i++) {
			if(number % i == 0) {
				counter++;
			}
		}
		if (counter == 2) {
			return true;
		}
		return false;
	}

}
