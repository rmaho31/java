package acalc;

public class Circle extends Shape {
	private double radius;
	
	public Circle(Double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	double getArea() {
		return radius*radius * Math.PI;
	}



	

}
