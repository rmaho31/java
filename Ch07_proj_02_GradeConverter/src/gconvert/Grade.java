package gconvert;

public class Grade {
	private static int number;
	private static String letter;
	
	public Grade() {
		number = 0;
	}
	
	public Grade(int number) {
		Grade.number = number;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return the letter
	 */
	public String getLetter() {
		if (number >= 88) {
			letter = "A"; 	
		} else if (number >= 80) {
			letter = "B";
		} else if (number >=67) {
			letter = "C";
		} else if (number >= 60) {
			letter = "D";
		} else if (number <= 59) {
			letter = "F";
		} else { 
			letter = "Not a Valid grade range!";
		}
		return letter;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		Grade.number = number;
	}

}
