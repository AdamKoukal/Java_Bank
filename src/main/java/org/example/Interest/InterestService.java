package org.example.Interest;

import org.example.accounts.SaveBankAccount;

import java.time.LocalDate;

public class InterestService
{
    public double calculateInterest(double money, SaveBankAccount saveBankAccount)
    {
        saveBankAccount.setNextInterestDate(saveBankAccount.getNextInterestDate().plusMonths(1));
        System.out.println(saveBankAccount.getNextInterestDate());
        return money*1.005;
    }
}
