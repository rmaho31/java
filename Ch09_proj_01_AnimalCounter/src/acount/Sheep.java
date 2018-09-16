package acount;

public class Sheep extends Animal implements Cloneable{
	private String name;
	
	public Sheep(String name) {
		this.name = name;
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
		return getCounter();
	}

	@Override
	public String getCountString() {
		return getCount() + " " + name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
    public Object clone() throws CloneNotSupportedException {
    	return super.clone();
    }
	
	
}
