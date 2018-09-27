package ttc.functionality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Node {
	private String[][] ttt;
	private int totalScore;
	private boolean maxPlayer;
	private List<Node> children;
	private int depth;
	private int alpha;
	private int beta;

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public Node(String[][] ttt, boolean maxPlayer, int alpha, int beta) {
		this.ttt = Arrays.copyOf(ttt, ttt[0].length);
		this. maxPlayer = maxPlayer;
		children = new ArrayList<>();
		this.alpha = alpha;
		this.beta = beta;
	}

	public int getAlpha() {
		return alpha;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public int getBeta() {
		return beta;
	}

	public void setBeta(int beta) {
		this.beta = beta;
	}

	public String[][] getTtt() {
		return ttt;
	}

	public void setTtt(String[][] ttt) {
		this.ttt = ttt;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public boolean isMaxPlayer() {
		return maxPlayer;
	}

	public void setMaxPlayer(boolean maxPlayer) {
		this.maxPlayer = maxPlayer;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void addChild(Node newNode) {
		children.add(newNode);
	}
}
