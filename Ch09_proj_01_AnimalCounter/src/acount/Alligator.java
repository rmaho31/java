package acount;

public class Alligator extends Animal {
	
	public Alligator () {
		super();
	}

	@Override
	public void incrementCount() {
		counter++;
		
	}

	@Override
	public void resetCount() {
		counter = 0;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return super.counter;
	}

	@Override
	public String getCountString() {
		return getCount() + " Alligator";
	}
	

}
