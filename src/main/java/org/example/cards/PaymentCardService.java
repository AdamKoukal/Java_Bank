package org.example.cards;

import com.google.inject.Singleton;
import org.example.accounts.BankAccountWithPaymentCards;
import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class PaymentCardService
{
    public Map<String, BankAccountWithPaymentCards> CardOwners = new HashMap<String, BankAccountWithPaymentCards>();
    
    private Logger logger=new ConsoleLogger();
    public void PaymentCardPay(PaymentCard paymentCard, double amount)
    {

        LocalDateTime date = LocalDateTime.now();
        logger.log(paymentCard.getExpiryMonth());
        logger.log(Integer.toString(Integer.parseInt(paymentCard.getExpiryYear())+2000));
        logger.log("Today's month"+date.getMonthValue());
        logger.log("Today's year"+date.getYear());
        if(Integer.parseInt(paymentCard.getExpiryMonth())>=date.getMonthValue() &&
                Integer.parseInt(paymentCard.getExpiryYear())+2000>=date.getYear())
        {
            logger.log("asdas");
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
