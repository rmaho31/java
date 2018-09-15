package abca;

abstract class Account implements Withdrawable, Depositable, Balanceable {
	private double balance;
	
	public Account() {
		balance = 0;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public void setBalance(double amount) {
		balance = amount;
		
	}

	@Override
	public void deposit(Double amount) {
		balance += amount;
		
	}

	@Override
	public void withdraw(Double amount) {
		balance -= amount;
		
	}
		
}
