package org.example.transactions;

import org.example.accounts.BaseBankAccount;

public class Transaction
{
    private int ID;

    private String TransactionDate;

    private BaseBankAccount Sender;

    private BaseBankAccount Receiver;

    private Double Amount;

    private String TransactionType;

    public Transaction(int ID, String TransactionDate, BaseBankAccount Sender, BaseBankAccount Receiver, Double Amount, String TransactionType){
        this.ID = ID;
        this.TransactionDate = TransactionDate;
        this.Sender = Sender;
        this.Receiver = Receiver;
        this.Amount = Amount;
        this.TransactionType = TransactionType;
    }

    public int getID() {
        return ID;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public BaseBankAccount getSender() {
        return Sender;
    }

    public BaseBankAccount getReceiver() {
        return Receiver;
    }

    public Double getAmount() {
        return Amount;
    }
    public String getTransactionType() {
        return TransactionType;
    }
}
