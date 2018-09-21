package ttc.functionality;

import java.util.List;

import ttc.players.Player;
import ttc.players.Score;

public class Node {
	private int row;
	private int column;
	private int totalScore;
	private Player p;
	private Score s;
	private List<Node> children; 

	public Node(int row, int column, int totalScore, Player p, Score s) {
		this.row = row;
		this.column = column;
		this.totalScore = totalScore;
		this.p = p;
		this.s = s;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public Player getP() {
		return p;
	}

	public void setP(Player p) {
		this.p = p;
	}

	public Score getS() {
		return s;
	}

	public void setS(Score s) {
		this.s = s;
	}


	public List<Node> getChildren() {
		return children;
	}

	public void addChild(Node newNode) {
		children.add(newNode);
	}
}
