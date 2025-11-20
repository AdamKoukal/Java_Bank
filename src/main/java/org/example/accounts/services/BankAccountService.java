package org.example.accounts.services;

import com.google.inject.Singleton;
import org.example.Transactions.Transaction;
import org.example.accounts.BankAccount;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.checks.BankAccountServiceChecker;
import org.example.accounts.BaseBankAccount;
import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class BankAccountService {


    public ArrayList<BaseBankAccount> BankAccounts= new ArrayList<BaseBankAccount>();

    private final Logger logger = new ConsoleLogger();

    private BankAccountServiceChecker Checker = new BankAccountServiceChecker();

    public void deposit(BaseBankAccount account, double amount) {
        /*if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }*/
        Checker.NegativeAmountCheck(amount,"Deposit amount must be positive.");

        logger.log(account.getUuid() + ": + " + amount);

        Checker.MoreMoneyThenCheck(amount, 10000);
        Checker.AntiAMLCheck(amount, 10000);

        /*if (amount > 10000) {
            System.err.println("Amount to be deposited is greater than 10000.");
        }*/

        // TODO AML legislativu (Anti Money Laundering – opatření proti praní špinavých peněz)

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);
    }

    public void withdraw(BaseBankAccount account, double amount) {

        Checker.NegativeAmountCheck(amount,"Withdraw amount must be positive.");
        /*if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }*/
        /*
        if (account.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds.");
        }*/
        Checker.MoneyOnAccountCheck(account.getBalance(), amount);

        logger.log(account.getUuid() + ": - " + amount);

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
    }

    public void executeTransaction(Transaction transaction, ArrayList<Transaction> transactions)
    {
        double transactionAmount = transaction.getAmount();

        BaseBankAccount sender = transaction.getSender();
        BaseBankAccount receiver = transaction.getReceiver();

        this.withdraw(sender,transactionAmount);
        this.deposit(receiver,transactionAmount);

        transactions.add(transaction);

    }
}
