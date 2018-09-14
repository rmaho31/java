package mahoney.app;

import java.text.NumberFormat;
import mahoney.account.*;
import mahoney.presentation.Console;

public class AccountBalanceApp {

    public static void main(String args[]) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        
        // display a welcome message
        System.out.println("Welcome to the Account application\n");

        // set some default amounts
        CheckingAccount checking = new CheckingAccount(1.0);  // $1 monthly fee
        SavingsAccount savings = new SavingsAccount(.01);     // 1% monthly interest
        checking.setBalance(1000.0); // $1000
        savings.setBalance(1000.0);  // $1000

        // display starting values
        System.out.println("Starting Balances");
        System.out.println("Checking: " + currency.format(checking.getBalance()));
        System.out.println("Savings:  " + currency.format(savings.getBalance()));
        System.out.println();

        System.out.println("Enter the transactions for the month\n");

        // continue until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
            String transactionType = Console.getString("Withdrawal or deposit? (w/d): ", "w", "d");
            String accountType = Console.getString("Checking or savings? (c/s): ", "c", "s");
            
            // set account 
            Account account;
            if (accountType.equalsIgnoreCase("c")) {  
                account = checking;
            } else {  
                account = savings;
            }
               
            // get amount and deposit or withdraw it 
            if (transactionType.equalsIgnoreCase("w")) {  // withdrawal
                double amount = Console.getDouble("Amount?: ", 0, account.getBalance());
                account.withdraw(amount);
            } else  {  // deposit
                double amount = Console.getDouble("Amount?: ", 0, 10000);  // $10,000 limit
                account.deposit(amount);
            }
            System.out.println();

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ", "y", "n");
            System.out.println();
        }

        // make month-end calculations
        checking.subtractMonthlyFee();
        savings.calculateMonthlyInterestPayment();

        // display monthly fees
        System.out.println("Monthly Payments and Fees");
        System.out.println("Checking fee:              " +
                currency.format(checking.getMonthlyFee()));
        System.out.println("Savings interest payment:  " +
                currency.format(savings.getMonthlyInterestPayment()));
        System.out.println();

        // display final balances
        System.out.println("Final Balances");
        System.out.println("Checking: " + currency.format(checking.getBalance()));
        System.out.println("Savings:  " + currency.format(savings.getBalance()));
        System.out.println();
    }
}