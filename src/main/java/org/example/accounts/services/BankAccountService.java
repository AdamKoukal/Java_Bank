package org.example.accounts.services;

import Checks.BankAccountServiceChecker;
import org.example.accounts.BaseBankAccount;
import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;

public class BankAccountService {

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
}
