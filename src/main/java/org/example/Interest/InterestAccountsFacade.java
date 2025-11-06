package org.example.Interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.SaveBankAccount;
import org.example.accounts.services.BankAccountService;

import java.time.LocalDate;
import java.util.Date;

@Singleton
public class InterestAccountsFacade extends Thread
{
    @Inject
    BankAccountService bankAccountService;

    @Inject
    InterestService interestService;

    public void run()
    {
        while(true)
        {
            //System.out.println(bankAccountService.BankAccounts.size());


            for(int i=0;i<bankAccountService.BankAccounts.size();i++)
            {

                if(bankAccountService.BankAccounts.get(i) instanceof SaveBankAccount
                        && ((SaveBankAccount) bankAccountService.BankAccounts.get(i)).getNextInterestDate()==LocalDate.parse("2000-01-01"))
                {
                    System.out.println("c");
                    bankAccountService.BankAccounts.get(i).setBalance(interestService.calculateInterest(bankAccountService.BankAccounts.get(i).getBalance(),(SaveBankAccount)bankAccountService.BankAccounts.get(i)));
                    System.out.println(bankAccountService.BankAccounts.get(i).getBalance());
                }
                else if(bankAccountService.BankAccounts.get(i) instanceof SaveBankAccount){
                    System.out.println(((SaveBankAccount) bankAccountService.BankAccounts.get(i)).getNextInterestDate()==LocalDate.parse("2000-01-01"));
                    System.out.println("ne c");
                }


            }
        }

    }
}
