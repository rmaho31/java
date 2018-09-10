package clist;

public class Contact {
	private static String fname;
	private static String lname;
	private static String email;
	private static String phoneNum;
	/**
	 * @return the fname
	 */
	public static String getFname() {
		return fname;
	}
	/**
	 * @return the lname
	 */
	public static String getLname() {
		return lname;
	}
	/**
	 * @return the email
	 */
	public static String getEmail() {
		return email;
	}
	/**
	 * @return the phoneNum
	 */
	public static String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * @param fname the fname to set
	 */
	public static void setFname(String fname) {
		Contact.fname = fname;
	}
	/**
	 * @param lname the lname to set
	 */
	public static void setLname(String lname) {
		Contact.lname = lname;
	}
	/**
	 * @param email the email to set
	 */
	public static void setEmail(String email) {
		Contact.email = email;
	}
	/**
	 * @param phoneNum the phoneNum to set
	 */
	public static void setPhoneNum(String phoneNum) {
		Contact.phoneNum = phoneNum;
	}
	
	
}
