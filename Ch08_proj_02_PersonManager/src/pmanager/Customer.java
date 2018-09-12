package pmanager;

public class Customer extends Person {
	private String number;
	
	public Customer(String fName, String lName, String number) {
		super(fName, lName);
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nCustomer number: " + number;
	}
}
