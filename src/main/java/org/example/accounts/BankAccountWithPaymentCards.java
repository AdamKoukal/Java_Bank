package org.example.accounts;

import org.example.Cards.PaymentCard;
import org.example.persons.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankAccountWithPaymentCards extends BaseBankAccount
{
    protected final List<PaymentCard> paymentCards;

    public BankAccountWithPaymentCards(String uuid, String banAccountNumber, Customer customer, double balance){
        super(uuid,banAccountNumber,customer,balance);

        this.paymentCards = new ArrayList<PaymentCard>();
    }

    public void addPaymentCard(PaymentCard paymentCard){
        this.paymentCards.add(paymentCard);
    }



}
