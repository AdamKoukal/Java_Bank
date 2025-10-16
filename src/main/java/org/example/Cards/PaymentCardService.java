package org.example.Cards;

import org.example.accounts.BankAccount;
import org.example.accounts.BankAccountWithPaymentCards;

public class PaymentCardService
{

    public void PaymentCardPay(BankAccountWithPaymentCards bankAccountWithPaymentCards, double amount)
    {
        if(bankAccountWithPaymentCards.paymentCards.size()>0)
        {
            if(bankAccountWithPaymentCards.getBalance()>=amount)
            {
                bankAccountWithPaymentCards.setBalance(bankAccountWithPaymentCards.getBalance()-amount);
            }

        }
    }


}
