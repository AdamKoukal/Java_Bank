package org.example.accounts;

import org.example.persons.customers.Customer;

import java.time.LocalDate;
import java.util.Date;

public class SaveBankAccount extends BaseBankAccount {

    private final float interestRate;

    private LocalDate nextInterestDate;

    public SaveBankAccount(String uuid, String bankAccountNumber, Customer customer, float interestRate, LocalDate nextInterestDate, double balance) {
        super(uuid, bankAccountNumber, customer, balance);

        this.interestRate = interestRate;
        this.nextInterestDate = nextInterestDate;
    }


    public float getInterestRate() {
        return interestRate;
    }

    public void setNextInterestDate(LocalDate nextInterestDate) {
        this.nextInterestDate=nextInterestDate;
    }

    public LocalDate getNextInterestDate() {
        return nextInterestDate;
    }
}
