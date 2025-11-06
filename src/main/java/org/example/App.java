package org.example;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.example.Interest.CronService;
import org.example.Interest.InterestAccountsFacade;
import org.example.accounts.SaveBankAccount;
import org.example.cards.PaymentCardFactory;
import org.example.cards.PaymentCardService;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.StudentBankAccount;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.BankAccountService;
import org.example.cards.generators.PaymentCardNumberGenerator;
import org.example.logger.ConsoleLogger;
import org.example.logger.FileSystemLogger;
import org.example.logger.Logger;
import org.example.persons.customers.Customer;
import org.example.persons.customers.factories.CustomerFactory;
import org.example.serialization.*;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.time.LocalDate;
import java.util.Date;

public class App {

    Logger logger = new ConsoleLogger();

    //Container container=new Container();

    @Inject
    PaymentCardService  paymentCardService;
    //PaymentCardService  paymentCardService = container.paymentCardService;

    @Inject
    PaymentCardFactory paymentCardFactory;
    //PaymentCardFactory paymentCardFactory = container.paymentCardFactory;
    @Inject
    CustomerFactory customerFactory;
    //CustomerFactory customerFactory = container.customerFactory;

    @Inject
    BankAccountService bankAccountService;
    //BankAccountService bankAccountService = container.bankAccountService;

    @Inject
    BankAccountFactory bankAccountFactory;
    //BankAccountFactory bankAccountFactory = container.bankAccountFactory;

    @Inject
    BankAccountOwnerSerializationFactory bankAccountOwnerSerializationFactory;
    //BankAccountOwnerSerializationFactory bankAccountOwnerSerializationFactory = container.bankAccountOwnerSerializationFactory;


    @Inject
    @Named("XML")
    Serialization bankAccountOwnerXMLSerializationService;
    //Serialization bankAccountOwnerXMLSerializationService = container.bankAccountOwnerXMLSerializationService;

    @Inject
    @Named("Json")
    Serialization bankAccountOwnerJsonSerializationService;
    //Serialization bankAccountOwnerJsonSerializationService = container.bankAccountOwnerJsonSerializationService;

    @Inject
    InterestAccountsFacade interestAccountsFacade;

    @Inject
    CronService cronService;




    public void run() {

        cronService.run();
        BankAccountOwnerSerialization test= bankAccountOwnerSerializationFactory.createBankAccountOwnerSerialization("1","1","1");


        Customer customer = customerFactory.createCustomer("c-123", "Tomas", "Pesek");

        SaveBankAccount saveBankAccount = bankAccountFactory.createSaveAccount("a",customer,5, LocalDate.parse("2000-01-01"),100);
        System.out.println(bankAccountService.BankAccounts.size());
        System.out.println(saveBankAccount.getNextInterestDate());


        logger.log(customer.getUuid() + ": " + customer.getFirstName() + " " + customer.getLastName());

        StudentBankAccount StudentBankAccountTest=bankAccountFactory.createStudentAccount(customer.getUuid(),customer,"Delta SŠ");

        StudentBankAccountTest.addPaymentCard(paymentCardFactory.create(),paymentCardService);

        logger.log("Test1 Balance: "+StudentBankAccountTest.getBalance());
        StudentBankAccountTest.setBalance(500);
        logger.log("Test1 Balance: "+StudentBankAccountTest.getBalance());


        paymentCardService.PaymentCardPay(StudentBankAccountTest.getPaymentCards().get(0),100);

        //logger.log(paymentCardService.GetPaymentCardOwner(StudentBankAccountTest.getPaymentCards().get(0)).toString());
        logger.log("Test1 Balance: "+StudentBankAccountTest.getBalance());





        /*logger.log(bankAccountOwnerXMLSerializationService.serialize(test));
        logger.log(bankAccountOwnerJsonSerializationService.serialize(test));

        logger.log("=== TEST BANK ACCOUNT");
        BaseBankAccount account1 = testBankAccount(customer);

        logger.log(account1 instanceof BankAccount ? "Bank" : "Save");

        logger.log("=== TEST SAVE ACCOUNT");
        BaseBankAccount account2 = testSaveAccount(customer);
        logger.log(account2 instanceof  BankAccount ? "Bank" : "Save");

        if (account2 instanceof SaveBankAccount) {
            float interestRate = ((SaveBankAccount)account2).getInterestRate();
            logger.log("Interest Rate: " + interestRate);
        }*/
    }

    private BaseBankAccount testSaveAccount(Customer customer) {
        BaseBankAccount account = bankAccountFactory.createSaveAccount(
                "u-123",
                customer,
                5,LocalDate.parse("2000-01-01"),
                100
        );

        try{
            logger.log(account.getUuid() + "(" + account.getBankAccountNumber() + "): " + account.getBalance());

            // account.addBalance(500);
            bankAccountService.deposit(account, 500);
            logger.log(account.getUuid() + ": " + account.getBalance());

            // account.subtractBalance(400);
            bankAccountService.withdraw(account, 500);
            logger.log(account.getUuid() + ": " + account.getBalance());

        } catch (Exception e) {
            logger.log("Error: " + e.getMessage());
        }

        return account;
    }

    private BaseBankAccount testBankAccount(Customer customer) {
        BaseBankAccount account = bankAccountFactory.createBankAccount(
                "u-123",
                customer
        );

        try {
            logger.log(account.getUuid() + " (" + account.getBankAccountNumber() + "): " + account.getBalance());

            // account.addBalance(500);
            bankAccountService.deposit(account, 500);
            logger.log(account.getUuid() + ": " + account.getBalance());

            bankAccountService.deposit(account, 400);
            logger.log(account.getUuid() + ": " + account.getBalance());

            // account.subtractBalance(300);
            bankAccountService.withdraw(account, 300);

        } catch (Exception e) {
            logger.log("Error: " + e.getMessage());
        }

        return account;
    }

}
