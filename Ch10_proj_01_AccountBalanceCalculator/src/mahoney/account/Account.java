package mahoney.account;
import mahoney.interfaces.*;

public class Account implements Depositable, Withdrawable, Balanceable {
    private double balance;

    public Account() {
        balance = 0;
    }

    // implement Depositable interface
    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    // implement Withdrawable interface
    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    // implement Balanceable interface
    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double amount) {
        balance = amount;
    }
}
