package org.example;

import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.accounts.services.BankAccountService;
import org.example.cards.PaymentCardFactory;
import org.example.cards.PaymentCardService;
import org.example.cards.generators.PaymentCardCvvGenerator;
import org.example.cards.generators.PaymentCardExpirationCalculator;
import org.example.cards.generators.PaymentCardNumberGenerator;
import org.example.cards.generators.PaymentCardPinGenerator;
import org.example.persons.customers.factories.CustomerFactory;
import org.example.serialization.BankAccountOwnerJsonSerializationService;
import org.example.serialization.BankAccountOwnerSerializationFactory;
import org.example.serialization.BankAccountOwnerXMLSerializationService;
import org.example.serialization.Serialization;

public class UnchangedContainer
{   //Cards
    public PaymentCardFactory paymentCardFactory;

    public PaymentCardService paymentCardService;

    public PaymentCardNumberGenerator paymentCardNumberGenerator;

    public PaymentCardCvvGenerator paymentCardCvvGenerator;

    public PaymentCardExpirationCalculator paymentCardExpirationCalculator;

    public PaymentCardPinGenerator paymentCardPinGenerator;

    //Customers

    public CustomerFactory customerFactory;

    //BankAccount

    public BankAccountFactory bankAccountFactory;

    public BankAccountService  bankAccountService;

    public BankAccountNumberGenerator bankAccountNumberGenerator;

    //Serialization

    public BankAccountOwnerSerializationFactory  bankAccountOwnerSerializationFactory;

    public Serialization bankAccountOwnerJsonSerializationService;

    public Serialization bankAccountOwnerXMLSerializationService;

    public UnchangedContainer()
    {

        //Cards
        this.paymentCardService=new PaymentCardService();

        this.paymentCardNumberGenerator=new PaymentCardNumberGenerator();

        this.paymentCardCvvGenerator=new PaymentCardCvvGenerator();

        this.paymentCardExpirationCalculator=new PaymentCardExpirationCalculator();

        this.paymentCardPinGenerator=new  PaymentCardPinGenerator();

        this.paymentCardFactory=new PaymentCardFactory
                (
                        paymentCardNumberGenerator,
                        paymentCardCvvGenerator,
                        paymentCardPinGenerator,
                        paymentCardExpirationCalculator
                );


        //Customers

        this.customerFactory=new CustomerFactory();

        //BankAccount

        this.bankAccountFactory=new BankAccountFactory();
        this.bankAccountService=new BankAccountService();
        this.bankAccountNumberGenerator=new BankAccountNumberGenerator();

        //Serialization

        this.bankAccountOwnerSerializationFactory=new BankAccountOwnerSerializationFactory();
        this.bankAccountOwnerJsonSerializationService=new BankAccountOwnerJsonSerializationService();
        this.bankAccountOwnerXMLSerializationService=new BankAccountOwnerXMLSerializationService();
    }


}
