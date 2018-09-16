package sc.business;

import java.util.LinkedList;

public class StackCalculator {
	LinkedList<Double> l;
	
	public StackCalculator() {
		l = new LinkedList<>();
	}

	public LinkedList<Double> getL() {
		return l;
	}

	public void setL(LinkedList<Double> l) {
		this.l = l;
	}

	public void push(double x) {
		l.addFirst(x);
	}
	
	public double pop() {
		return l.removeFirst();
	}
	
	public double add() {
		return l.removeFirst() + l.removeFirst();
	}
	
	public double subtract() {
		return l.removeFirst() - l.removeFirst();
	}
	
	public double multiply() {
		return l.removeFirst() * l.removeFirst();
	}
	
	public double divide() {
		return l.removeFirst() / l.removeFirst();
	}
	
	public void clear() {
		l.removeAll(l);
	}
	
	public double[] getValues() {
		double[] d1 = new double[size()];
		int i = 0;
		for(double d : l) {
			d1[i] = d;
			i++;
		}
		return d1;
	}
	
	public int size() {
		return l.size();
	}

	@Override
	public String toString() {
		String s = "";
		if(l.isEmpty()) {
			s = "empty";
		} else {
			for(double d : l) {
				s += d + "\n";
			}			
		}
		return s;
	}	

}
