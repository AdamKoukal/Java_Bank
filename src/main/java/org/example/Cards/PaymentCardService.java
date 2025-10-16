package org.example.Cards;

import org.example.accounts.BankAccount;
import org.example.accounts.BankAccountWithPaymentCards;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PaymentCardService
{
    public static Map<String, BankAccountWithPaymentCards> CardOwners = new HashMap<String, BankAccountWithPaymentCards>();

    public void PaymentCardPay(PaymentCard paymentCard, double amount)
    {
        LocalDateTime date = LocalDateTime.now();
        if(Integer.parseInt(paymentCard.getExpiryMonth())>date.getMonthValue() &&
                Integer.parseInt(paymentCard.getExpiryYear())>date.getYear())
        {
            if(GetPaymentCardOwner(paymentCard).getBalance()>=amount)
            {
                GetPaymentCardOwner(paymentCard).setBalance(GetPaymentCardOwner(paymentCard).getBalance()-amount);
            }
        }
    }

    public BankAccountWithPaymentCards GetPaymentCardOwner(PaymentCard paymentCard)
    {
        return CardOwners.get(paymentCard.getCardUuid());
    }



}
