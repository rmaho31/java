package abca;

public class SavingsAccount extends Account {
	Double rate;
	Double payment;
	
	public SavingsAccount(Double rate) {
		this.rate = rate;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getPayment() {
		payment = super.getBalance()*rate;
		return payment;
	}

	public void addPayment() {
		super.setBalance(super.getBalance() + payment);
	}
	
	
	
	
	
	
}
