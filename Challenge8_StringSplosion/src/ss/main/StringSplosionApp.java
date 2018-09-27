package ss.main;

public class StringSplosionApp {

	public static void main(String[] args) {
		System.out.println(splodin("Code"));
	}
	
	public static String splodin(String s) {
		String string = "";
		if(!s.equals("")) {
			for(int i = 0; i < s.length(); i++) {
				string += s.substring(0, i+1);			
			}
		} else {
			System.out.println("Must Enter a non-empty String");
		}
		return string;
		
	}

}
