package acalc;

public class Square extends Shape{
	private double width;
	
	public Square(Double width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	double getArea() {
		return width*width;
	}
}
