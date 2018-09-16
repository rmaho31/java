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

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public int[] getRowSums() {
		return rowSums;
	}

	public void setRowSums(int[] rowSums) {
		this.rowSums = rowSums;
	}

	public int[] getDiagonalSums() {
		return diagonalSums;
	}

	public void setDiagonalSums(int[] diagonalSums) {
		this.diagonalSums = diagonalSums;
	}

	public int[] getColumnSums() {
		return columnSums;
	}

	public void setColumnSums(int[] columnSums) {
		this.columnSums = columnSums;
	}

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
