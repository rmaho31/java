package mahoney.account;
public class CheckingAccount extends Account {
    private double monthlyFee;

    public CheckingAccount(double monthlyFee) {
        super();
        this.monthlyFee = monthlyFee;
    }

    public void subtractMonthlyFee() {
        double balance = super.getBalance();
        double newBalance = balance - monthlyFee;
        super.setBalance(newBalance);
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}
