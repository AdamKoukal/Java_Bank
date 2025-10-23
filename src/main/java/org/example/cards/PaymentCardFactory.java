package org.example.cards;

import org.example.cards.generators.PaymentCardCvvGenerator;
import org.example.cards.generators.PaymentCardExpirationCalculator;
import org.example.cards.generators.PaymentCardNumberGenerator;
import org.example.cards.generators.PaymentCardPinGenerator;

import java.util.UUID;

public class PaymentCardFactory
{
    private PaymentCardNumberGenerator paymentCardNumberGenerator;
    private PaymentCardCvvGenerator paymentCardCvvGenerator;
    private PaymentCardPinGenerator paymentCardPinGenerator;
    private PaymentCardExpirationCalculator paymentCardExpirationGenerator;

    public PaymentCardFactory(
                              PaymentCardNumberGenerator paymentCardNumberGenerator,
                              PaymentCardCvvGenerator paymentCardCvvGenerator,
                              PaymentCardPinGenerator paymentCardPinGenerator,
                              PaymentCardExpirationCalculator paymentCardExpirationGenerator

                             )
    {
        this.paymentCardNumberGenerator = paymentCardNumberGenerator;
        this.paymentCardCvvGenerator = paymentCardCvvGenerator;
        this.paymentCardPinGenerator = paymentCardPinGenerator;
        this.paymentCardExpirationGenerator = paymentCardExpirationGenerator;
    }



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
