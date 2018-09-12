package abca;

public class CheckingAccount extends Account {
	private double monthlyFee;
	
	public CheckingAccount(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	
	public void deductFees() {
		super.setBalance(super.getBalance() - monthlyFee);
		
	}
	
	
	

}
