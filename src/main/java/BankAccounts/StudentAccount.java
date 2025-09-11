package BankAccounts;

import People.BankAccountOwner;

public class StudentAccount extends BaseBankAccount
{
    private String School;

    public StudentAccount(String uuid, String accountNumber, BankAccountOwner AccountOwner, double Balance, String School){
        super(uuid,accountNumber,AccountOwner,Balance);
        this.School=School;
    }
}
