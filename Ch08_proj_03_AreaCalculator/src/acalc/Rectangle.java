package acalc;

public class Rectangle extends Shape {
	private double width;
	private double height;
	
	public Rectangle(Double width, Double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	double getArea() {
		return width*height;
	}
	
	

}
