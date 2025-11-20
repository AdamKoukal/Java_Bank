package org.example.transactions;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class TransactionCronService
{
    @Inject
    private TransactionFacade transactionFacade;


    public void run(){
        Thread Cron = new Thread(transactionFacade);
        Cron.start();
    }
}
