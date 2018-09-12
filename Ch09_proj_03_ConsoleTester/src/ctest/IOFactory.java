package ctest;

public class IOFactory {
	
	public static UserIO getUserIO(String type) {
		if (type.equalsIgnoreCase("ConsoleIO")) {
			ConsoleIO cIO = new ConsoleIO();
			return cIO;			
		} else {
			JOptionPaneIO jIO = new JOptionPaneIO();
			return jIO;
		}
	}
}
