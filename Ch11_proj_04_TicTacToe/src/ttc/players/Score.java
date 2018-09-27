package ttc.players;

import java.util.Arrays;

public class Score {
	private int[] rowSums;
	private int[] diagonalSums;
	private int[] columnSums;
	
	public Score(int size) {
		rowSums = new int[size];
		diagonalSums = new int[2];
		columnSums = new int[size];	
	}
	
	public Score(Score s) {
		rowSums = Arrays.copyOf(s.getRowSums(), s.getRowSums().length);				
		columnSums = Arrays.copyOf(s.getColumnSums(), s.getColumnSums().length);
		diagonalSums = Arrays.copyOf(s.getDiagonalSums(), s.getDiagonalSums().length);
	}
	
	public int[] getRowSums() {
		return rowSums;
	}

	public void setRowSums(int score, int index) {
		this.rowSums[index] = score;
	}

	public int[] getDiagonalSums() {
		return diagonalSums;
	}

	public void setDiagonalSums(int score, int index) {
		this.diagonalSums[index] = score;
	}

	public int[] getColumnSums() {
		return columnSums;
	}

	public void setColumnSums(int score, int index) {
		this.columnSums[index] = score;
	}

	public void adjustColumnSums(int index, Player p) {
		if(p.getLetter().equals("X")){
			if(columnSums[index] > 0) {
				columnSums[index] *= 10;
			} else {
				columnSums[index]++;				
			}
		} else {
			if(columnSums[index] < 0) {
				columnSums[index] *= 10;
			} else {
				columnSums[index]--;				
			}
		}
	}
	
	public void adjustColumnSums(int index, boolean isMaxPlayer) {
		if(isMaxPlayer){
			if(columnSums[index] > 0) {
				columnSums[index] *= 10;
			} else {
				columnSums[index]++;				
			}
		} else {
			if(columnSums[index] < 0) {
				columnSums[index] *= 10;
			} else {
				columnSums[index]--;				
			}
		}
	}
	
	public void adjustRowSums(int index, Player p) {
		if(p.getLetter().equals("X")){
			if(rowSums[index] > 0) {
				rowSums[index] *= 10;
			} else {
				rowSums[index]++;				
			}
		} else {
			if(rowSums[index] < 0) {
				rowSums[index] *= 10;
			} else {
				rowSums[index]--;				
			}
		}
	}
	
	public void adjustRowSums(int index, boolean isMaxPlayer) {
		if(isMaxPlayer){
			if(rowSums[index] > 0) {
				rowSums[index] *= 10;
			} else {
				rowSums[index]++;				
			}
		} else {
			if(rowSums[index] < 0) {
				rowSums[index] *= 10;
			} else {
				rowSums[index]--;				
			}
		}
	}
	
	public void adjustDiagonalSums(int index, Player p) {
		if(p.getLetter().equals("X")){
			if(diagonalSums[index] > 0) {
				diagonalSums[index] *= 10;
			} else {
				diagonalSums[index]++;				
			}
		} else {
			if(diagonalSums[index] < 0) {
				diagonalSums[index] *= 10;
			} else {
				diagonalSums[index]--;				
			}
		}
	}
	
	public void adjustDiagonalSums(int index, boolean isMaxPlayer) {
		if(isMaxPlayer){
			if(diagonalSums[index] > 0) {
				diagonalSums[index] *= 10;
			} else {
				diagonalSums[index]++;				
			}
		} else {
			if(diagonalSums[index] < 0) {
				diagonalSums[index] *= 10;
			} else {
				diagonalSums[index]--;				
			}
		}
	}
}
