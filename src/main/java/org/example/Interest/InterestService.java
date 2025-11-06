package org.example.Interest;

import org.example.accounts.SaveBankAccount;

public class InterestService
{
    public double calculateInterest(double money, SaveBankAccount saveBankAccount)
    {
        saveBankAccount.setNextInterestDate(saveBankAccount.getNextInterestDate().plusMonths(1));
        return money*1.005;
    }
}
