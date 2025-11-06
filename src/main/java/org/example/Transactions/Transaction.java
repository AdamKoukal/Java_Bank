package org.example.Transactions;

import org.example.accounts.BaseBankAccount;

import java.time.LocalDate;
import java.util.Date;

public class Transaction
{
    int ID;

    LocalDate TransactionDate;

    BaseBankAccount Sender;

    BaseBankAccount Receiver;

    Double Amount;

    String TransactionType;

    public Transaction(int ID, LocalDate TransactionDate, BaseBankAccount Sender, BaseBankAccount Receiver, Double Amount, String TransactionType){
        this.ID = ID;
        this.TransactionDate = TransactionDate;
        this.Sender = Sender;
        this.Receiver = Receiver;
        this.Amount = Amount;
        this.TransactionType = TransactionType;
    }
}
