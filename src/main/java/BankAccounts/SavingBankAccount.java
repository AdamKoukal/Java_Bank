package BankAccounts;

import People.BankAccountOwner;

public class SavingBankAccount extends BaseBankAccount{

    public SavingBankAccount(String uuid, String accountNumber, BankAccountOwner owner, double balance) {
        super(uuid, accountNumber, owner, balance);
    }
}
