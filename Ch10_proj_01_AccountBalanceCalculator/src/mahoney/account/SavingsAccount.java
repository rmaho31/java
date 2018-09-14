package mahoney.account;
public class SavingsAccount extends Account {
    private double monthlyInterestRate;
    private double monthlyInterestPayment;

    public SavingsAccount(double monthlyInterestRate) {
        super();
        this.monthlyInterestRate = monthlyInterestRate;
    }

    public void calculateMonthlyInterestPayment() {
        double balance = super.getBalance();
        monthlyInterestPayment = monthlyInterestRate * balance;
        double newBalance = balance + monthlyInterestPayment;
        super.setBalance(newBalance);
    }

    public double getMonthlyInterestPayment() {
        return monthlyInterestPayment;
    }
}