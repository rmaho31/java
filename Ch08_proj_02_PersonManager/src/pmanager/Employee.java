package pmanager;

public class Employee extends Person {
	private String ssn;
	
	public Employee(String fName, String lName, String ssn) {
		super(fName,lName);
		this.ssn = ssn;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	public String toString() {
		return super.toString() + "\nSSN: " + ssn.replaceAll("^\\d+?-\\d+?-", "xxx-xxxx-");
	}
}
