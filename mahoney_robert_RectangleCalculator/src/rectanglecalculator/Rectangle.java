package rectanglecalculator;

public class Rectangle {
	private static double length;
	private static double width;
	
	public static double getLength() {
		return length;
	}
	
	public static double getWidth() {
		return width;
	}
	
	public static void setLength(double x) {
		length = x;
	}
	
	public static void setWidth(double x) {
		width = x;
	}
	
	public static double getArea(double width, double length) {
		return width * length;
	}
	
	public static double getPerimeter(double width, double length) {
		return width * 2 + length * 2;
	}
}
