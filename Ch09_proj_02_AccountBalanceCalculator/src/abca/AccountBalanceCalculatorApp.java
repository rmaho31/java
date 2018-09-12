package abca;

import java.text.NumberFormat;

public class AccountBalanceCalculatorApp {
	private static NumberFormat c = NumberFormat.getCurrencyInstance();

	public static void main(String[] args) {
		System.out.println("Welcome to the Account Application\n");
		
		//initialize Savings with 1% interest
		SavingsAccount s1 = new SavingsAccount(.01);
		
		//Initialize Checking with $1.00 monthlyFee
		CheckingAccount c1 = new CheckingAccount(1.0);
		s1.setBalance(1000.00);
		c1.setBalance(1000.00);
		
		String choice1 = "y";
		while(choice1.equalsIgnoreCase("y")) {
			
			printStartingBalances(c1, s1);
			
			String choice2 = "y";
			while(choice2.equalsIgnoreCase("y")){
				
				//allow user to select and enter transactio types for the month
				getTransactionType(c1,s1);
				
				choice2 = Console.getString("\nAnother transaction? (y/n): ", "y", "n");
			}
			
			// show monthly fees and balances
			getFeesAndBalances(c1, s1);
			
			choice1 = Console.getString("\nAnother month? (y/n): ", "y", "n");
		}
	}
	
	private static void printStartingBalances(CheckingAccount c1, SavingsAccount s1) {
		
		System.out.println("Starting Balances");
		System.out.println("Checking: " + c.format(c1.getBalance()));
		System.out.println("Savings: " + c.format(s1.getBalance()));
		
		System.out.println("\nEnter the transactions for the month\n");		
	}
	
	private static void getFeesAndBalances(CheckingAccount c1, SavingsAccount s1) {
		System.out.println("Monthly payment and fees");
		System.out.println("Checking fee\t\t\t" + c.format(c1.getMonthlyFee()));
		System.out.println("Savings interest payment:\t" + c.format(s1.getPayment()));
		c1.deductFees();
		s1.addPayment();
		
		System.out.println("\nFinal Balances");
		System.out.println("Checking:\t" + c.format(c1.getBalance()));
		System.out.println("Savings:\t" + c.format(s1.getBalance()));
		
	}
	
	private static void getTransactionType(CheckingAccount c1, SavingsAccount s1) {
		String tranType = Console.getString("Withdrawal or deposit? (w/d): ", "w", "d");
		String accountType = Console.getString("Checking or savings? (c/s): ", "c", "s");
		
		if (tranType.equalsIgnoreCase("w")) {
			if (accountType.equalsIgnoreCase("c")) {
				c1.withdraw(Console.getDouble("Amount?: ", 0, c1.getBalance()));
			} else {
				s1.withdraw(Console.getDouble("Amount?: ", 0, s1.getBalance()));
			}				
		} else {
			if (accountType.equalsIgnoreCase("c")) {
				c1.deposit(Console.getDouble("Amount?: ", 0, Double.POSITIVE_INFINITY));
			} else {
				s1.deposit(Console.getDouble("Amount?: ", 0, Double.POSITIVE_INFINITY));
			}
		}
		
	}

}
