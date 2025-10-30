package org.example.cards;

import com.google.inject.Inject;
import org.example.cards.generators.PaymentCardCvvGenerator;
import org.example.cards.generators.PaymentCardExpirationCalculator;
import org.example.cards.generators.PaymentCardNumberGenerator;
import org.example.cards.generators.PaymentCardPinGenerator;

import java.util.UUID;

public class PaymentCardFactory
{
    @Inject
    private PaymentCardNumberGenerator paymentCardNumberGenerator;
    @Inject
    private PaymentCardCvvGenerator paymentCardCvvGenerator;
    @Inject
    private PaymentCardPinGenerator paymentCardPinGenerator;
    @Inject
    private PaymentCardExpirationCalculator paymentCardExpirationGenerator;




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
