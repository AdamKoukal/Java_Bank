package BankAccounts;

import People.BankAccountOwner;

public class BankAccount extends BaseBankAccount
{
    public BankAccount(String uuid, String name, BankAccountOwner AccountOwner,double balance)
    {
        super(uuid,name,AccountOwner,balance);
    }
}
