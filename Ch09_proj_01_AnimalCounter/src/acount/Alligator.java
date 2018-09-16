package acount;

public class Alligator extends Animal {
	
	public Alligator () {
	}

	@Override
	public void incrementCount() {
		setCounter(getCounter() + 1);
		
	}

	@Override
	public void resetCount() {
		setCounter(0);
		
	}

	@Override
	public int getCount() {
		return super.getCounter();
	}

	@Override
	public String getCountString() {
		return getCount() + " Alligator";
	}
	

}
