package ctest;

public class UserIOTestApp {

	public static void main(String[] args) {
		UserIO sc = IOFactory.getUserIO("JOptionPaneIO");
		if(sc instanceof ConsoleIO) {
			sc.println("Welcome to the Console Tester Application!\n");
			
			sc.println("Int Test");
			sc.getInt("Enter an int between -100 and 100: ", -100, 100);
			
			sc.println("\nDouble Test");
			sc.getDouble("Enter any number between -100 and 100: ", -100, 100);
			
			sc.println("\nRequired String Test");
			sc.getString("Enter your email address: ");
			
			sc.println("\nString Choice Test");
			sc.getString("Select one (x/y): ", "x", "y");			
		} else if (sc instanceof JOptionPaneIO) {
			((JOptionPaneIO) sc).showInputDialog("Waaaaassssssssuuuuuuppppp");
			((JOptionPaneIO) sc).showMessageDialog("This prog is broken for sho");
		}
	}
}
