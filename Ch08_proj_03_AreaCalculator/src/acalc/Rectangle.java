package acalc;

public class Rectangle extends Square {
	private double height;
	
	public Rectangle(Double width, Double height) {
		super(width);
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	double getArea() {
		return super.getWidth()*height;
	}
}
