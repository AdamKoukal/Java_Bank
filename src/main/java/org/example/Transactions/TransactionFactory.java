package org.example.Transactions;

import org.example.accounts.BaseBankAccount;

import java.time.LocalDate;

public class TransactionFactory
{
    public Transaction createTransaction(int ID,String TransactionDate, BaseBankAccount Sender, BaseBankAccount Receiver, Double Amount, String TransactionType){
        return new Transaction(ID,TransactionDate, Sender, Receiver, Amount, TransactionType);
    }
}
