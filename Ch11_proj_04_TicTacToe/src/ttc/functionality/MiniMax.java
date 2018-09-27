package ttc.functionality;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class MiniMax {
    private Tree tree;
    private int alpha;
    private int beta;

    public Tree getTree() {
        return tree;
    }

    public void constructTree(String[][] ttt) {
        tree = new Tree();
        Node root = new Node(ttt, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        tree.setRoot(root);
        constructTree(root);
    }

    private void constructTree(Node parentNode) {
        List<int[]> listPossibleMoves = TicTacToe.generateMoves(parentNode.getTtt());
        boolean isChildMaxPlayer = !parentNode.isMaxPlayer();
        for(int[] n : listPossibleMoves) {
        	
        	String[][] tttCopy = copyArray(parentNode.getTtt());
        	if(isChildMaxPlayer) {
        		tttCopy[n[0]][n[1]] = "X";    
        	} else {
        		tttCopy[n[0]][n[1]] = "O"; 
        	}
            Node newNode = new Node(tttCopy, isChildMaxPlayer, parentNode.getAlpha(), parentNode.getBeta());
            newNode.setTotalScore(returnScoresForMoves(tttCopy, parentNode.isMaxPlayer()));  
            newNode.setDepth(parentNode.getDepth() + 1);
            if(parentNode.isMaxPlayer()) {
            	if(newNode.getTotalScore() > parentNode.getAlpha()) {
            	parentNode.setAlpha(newNode.getTotalScore());
            	}
            } else {
            	if(newNode.getTotalScore() < parentNode.getBeta()) {
            		parentNode.setBeta(newNode.getTotalScore());
            	}
            }
            newNode.setAlpha(parentNode.getAlpha());
            newNode.setBeta(parentNode.getBeta());
            parentNode.addChild(newNode);
            if(parentNode.getAlpha() > parentNode.getBeta()) {
        		break;
        	}
            if (TicTacToe.generateMoves(newNode.getTtt()).size() > 0 && 
            	Math.abs(newNode.getTotalScore()) < 100) {
                constructTree(newNode);
            }
        }
    }
    
    public int[] returnBestMove() {
    	List<Node> children = tree.getRoot().getChildren();
    	List<int[]> listPossibleMoves = TicTacToe.generateMoves(tree.getRoot().getTtt());
    	Node bestChild = findBestChild(true, children);
    	return listPossibleMoves.get(children.indexOf(bestChild));
    }
    
    
    public boolean checkWin() {
        Node root = tree.getRoot();
        checkWin(root);
        return root.getTotalScore() == -100;
    }

    private void checkWin(Node node) {
        List<Node> children = node.getChildren();
        boolean isMaxPlayer = node.isMaxPlayer();
        children.forEach(child -> {
            if (TicTacToe.generateMoves(child.getTtt()).size() > 0 &&
            	Math.abs(child.getTotalScore()) < 100 && node.getAlpha() <= node.getBeta()) {
                checkWin(child);
            }
        });
        Node bestChild = findBestChild(isMaxPlayer, children);
        node.setTotalScore(bestChild.getTotalScore() - bestChild.getDepth());
    }

    private Node findBestChild(boolean isMaxPlayer, List<Node> children) {
        Comparator<Node> byScoreComparator = Comparator.comparing(Node::getTotalScore);

        return children.stream()
          .max(isMaxPlayer ? byScoreComparator : byScoreComparator.reversed())
          .orElseThrow(NoSuchElementException::new);
    }  
  	
  	public int returnScoresForMoves(String[][] ttt, boolean isMaxPlayer) {
  		int totalScore = 0;
  		int[] rowScore = new int[ttt[0].length];
  		int[] colScore = new int[ttt[0].length];
  		int[] diagScore = new int[2];
  		String letter = "";
  		if(isMaxPlayer) {
  			letter = "O";
  		} else {
  			letter = "X";
  		}
		for (int i = 0; i < ttt[0].length; i++) {
			for (int j = 0; j < ttt[0].length; j++) {
				if(ttt[i][j].equals(letter)) {
					rowScore[i]++;
					colScore[j]++;
					if(i == j) {
						diagScore[0]++;
					} 
					if(i == ttt[0].length - j - 1) {
						diagScore[1]++;
					}
				}
			}
		}
		for(int s : rowScore) {
			if(s == ttt[0].length) {
				totalScore = 100;
			} 
		}
		for(int s : colScore) {
			if(s == ttt[0].length) {
				totalScore = 100;
			} 
		}
		for(int s : diagScore) {
			if(s == ttt[0].length) {
				totalScore = 100;
			}
		}
		if(!isMaxPlayer) {
			totalScore = (-totalScore);
		}
	return totalScore; 
  	}
  	
  	public String[][] copyArray(String[][] ttt){
  		String[][] copy =  new String[ttt[0].length][ttt[0].length];
  		for(int i = 0; i < ttt[0].length; i++) {
  			for(int j = 0; j < ttt[0].length; j++) {
  				copy[i][j] = ttt[i][j];
  			}
  		}
  		return copy;
  	}
}