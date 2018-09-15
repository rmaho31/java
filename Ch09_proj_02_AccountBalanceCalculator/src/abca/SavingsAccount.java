package abca;

public class SavingsAccount extends Account {
	double rate;
	double payment;
	
	public SavingsAccount(Double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public double getPayment() {
		return payment;
	}
	
	public void setPayment(double payment) {
		this.payment = payment;
	}

	public void applyPayment() {
		setPayment(super.getBalance()*rate);
		super.setBalance(super.getBalance() + payment);
	}
	
	
	
	
	
	
}
