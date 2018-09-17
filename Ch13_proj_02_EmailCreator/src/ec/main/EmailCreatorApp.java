package ec.main;

public class EmailCreatorApp {

	public static void main(String[] args) {
		String[] csv = {"   james   ,butler,jbutler@gmail.com",
                "Josephine,Darakjy,Josephine_Darakjy@darakjy.org",
                "ART,VENERE,ART@VENERE.ORG"};		
		
		printEmails(csv);


	}
	
	public static String formatName(String name) {
		name = name.trim();
		name = name.toLowerCase();
		char fl = name.substring(0,1).toUpperCase().charAt(0);
		name = name.replace(name.charAt(0), fl);
		return name;
	}
	
	public static String formatEmailAddress(String email) {
		email = email.toLowerCase();
		return email;
	}
	
	public static void printEmails(String[] csv) {
		for(String s : csv) {
			String[] user = s.split(",");
			String fName = formatName(user[0]);
			//String lName = formatName(user[1]);
			String email = formatEmailAddress(user[2]);
			String template = 
					"==============================================================\n\n" +
				    "To:      " + email + "\n" +
				    "From:    noreply@deals.com\n" +
				    "Subject: Deals!\n\n" +
				    "Hi " + fName + ",\n\n" +
				    "We've got some great deals for you. Check our website!\n";
			System.out.println(template);
		}
	}
}
