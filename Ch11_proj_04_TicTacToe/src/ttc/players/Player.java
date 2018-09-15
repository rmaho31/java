package ttc.players;

public class Player {
	private String letter;
	private int[] rowSums;
	private int[] diagonalSums;
	private int[] columnSums;
	
	
	public Player(String letter, int size) {
		this.letter = letter;
		rowSums = new int[size];
		diagonalSums = new int[2];
		columnSums = new int[size];		
	}

	/**
	 * @return the letter
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * @param letter the letter to set
	 */
	public void setLetter(String letter) {
		this.letter = letter;
	}

	/**
	 * @return the rowSums
	 */
	public int[] getRowSums() {
		return rowSums;
	}

	/**
	 * @param rowSums the rowSums to set
	 */
	public void setRowSums(int[] rowSums) {
		this.rowSums = rowSums;
	}

	/**
	 * @return the diagonalSums
	 */
	public int[] getDiagonalSums() {
		return diagonalSums;
	}

	/**
	 * @param diagonalSums the diagonalSums to set
	 */
	public void setDiagonalSums(int[] diagonalSums) {
		this.diagonalSums = diagonalSums;
	}

	/**
	 * @return the columnSums
	 */
	public int[] getColumnSums() {
		return columnSums;
	}

	/**
	 * @param columnSums the columnSums to set
	 */
	public void setColumnSums(int[] columnSums) {
		this.columnSums = columnSums;
	}
	
	/**
	 * @param index to increment
	 */
	public void incrementColumnSums(int index) {
		columnSums[index]++;
	}
	
	public void incrementRowSums(int index) {
		rowSums[index]++;
	}
	
	public void incrementDiagonalSums(int index) {
		diagonalSums[index]++;
	}
}
