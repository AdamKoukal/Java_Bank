package org.example.Cards;

public class PaymentCard
{
    private String cardNumber;

    private String uuid;

    private String cvv;

    private String pin;

    private String expiryMonth;

    private String expiryYear;

public  PaymentCard(String cardNumber, String uuid, String cvv, String pin, String expiryMonth, String expiryYear)
{


    this.cardNumber = cardNumber;
    this.uuid = uuid;
    this.cvv = cvv;
    this.pin = pin;
    this.expiryMonth = expiryMonth;
    this.expiryYear = expiryYear;

}

    public String getExpiryMonth() {
        return expiryMonth;
    }

    public String getExpiryYear() {
    return expiryYear;
    }

    public String getCardUuid() {
    return uuid;
    }
}

