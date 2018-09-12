package acount;

public class Sheep extends Animal implements Cloneable{
	private String name;
	
	public Sheep(String name) {
		super();
		this.name = name;
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
		return counter;
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
