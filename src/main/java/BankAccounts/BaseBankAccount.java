package BankAccounts;

import People.BankAccountOwner;

public class BaseBankAccount
{
    private String uuid;

    private String accountNumber;

    private BankAccountOwner AccountOwner;
    private double balance;//BigDecimal;

    public BaseBankAccount(String uuid, String accountNumber, BankAccountOwner AccountOwner, double Balance)
    {
        this.uuid = uuid;
        this.accountNumber = accountNumber;
        this.AccountOwner = AccountOwner;
        this.balance = Balance;
    }

    public String getUuid(){
        return uuid;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public BankAccountOwner getAccountOwner(){
        return AccountOwner;
    }
    public double getBalance(){
        return balance;
    }
    public void addBalance(double amount){
        this.balance += amount;
    }
    public void removeBalance(double amount){
        if(balance >= amount){
            this.balance -= amount;
        }
        else{
            System.out.println("Not enough balance");
        }
    }
}