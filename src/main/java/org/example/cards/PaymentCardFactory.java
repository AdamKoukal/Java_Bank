package org.example.cards;

import org.example.cards.generators.PaymentCardCvvGenerator;
import org.example.cards.generators.PaymentCardExpirationCalculator;
import org.example.cards.generators.PaymentCardNumberGenerator;
import org.example.cards.generators.PaymentCardPinGenerator;

import java.util.UUID;

public class PaymentCardFactory
{
    private PaymentCardNumberGenerator paymentCardNumberGenerator= new PaymentCardNumberGenerator();
    private PaymentCardCvvGenerator paymentCardCvvGenerator= new PaymentCardCvvGenerator();
    private PaymentCardPinGenerator paymentCardPinGenerator= new PaymentCardPinGenerator();
    private PaymentCardExpirationCalculator paymentCardExpirationGenerator= new PaymentCardExpirationCalculator();

    public PaymentCard create()
    {
        String uuid= UUID.randomUUID().toString();
        String cardNumber = this.paymentCardNumberGenerator.generateCardNumber();
        String cvv = this.paymentCardCvvGenerator.generateCardCvv();

        String pin = this.paymentCardPinGenerator.generateCardPin();
        String expireMonth=this.paymentCardExpirationGenerator.CalculateMonthExpire();
        String expireYear=this.paymentCardExpirationGenerator.CalculateYearExpire();

        return new PaymentCard(uuid,cardNumber,cvv,pin,expireMonth,expireYear);
    }



}
