package org.example.Transactions;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.Interest.InterestAccountsFacade;

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
