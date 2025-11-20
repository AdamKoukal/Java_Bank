package org.example.Transactions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.services.BankAccountService;

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
