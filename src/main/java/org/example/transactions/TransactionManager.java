package org.example.transactions;

import com.google.inject.Singleton;

import java.util.ArrayList;

@Singleton
public class TransactionManager
{
    public ArrayList<Transaction> transactions=new ArrayList<>();

    public ArrayList<Transaction> getTransactions()
    {
        return transactions;
    }
}
