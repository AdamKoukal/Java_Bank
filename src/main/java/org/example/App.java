package org.example;

import org.example.accounts.BankAccount;
import org.example.accounts.BaseBankAccount;
import org.example.accounts.SaveBankAccount;
import org.example.accounts.factories.BankAccountFactory;
import org.example.accounts.services.BankAccountService;
import org.example.logger.FileSystemLogger;
import org.example.logger.Logger;
import org.example.persons.customers.Customer;
import org.example.persons.customers.factories.CustomerFactory;
import org.example.serialization.BankAccountOwnerSerialization;
import org.example.serialization.BankAccountOwnerSerializationFactory;
import org.example.serialization.BankAccountOwnerXMLSerializationService;
import org.example.serialization.BankAccountOwnerJsonSerializationService;

public class App {

    Logger logger = new FileSystemLogger();

    BankAccountOwnerSerializationFactory bankAccountOwnerSerializationFactory = new BankAccountOwnerSerializationFactory();
    BankAccountOwnerSerialization test= bankAccountOwnerSerializationFactory.createBankAccountOwnerSerialization("1","1","1");
    CustomerFactory customerFactory = new CustomerFactory();
    BankAccountService bankAccountService = new BankAccountService();
    BankAccountFactory bankAccountFactory = new BankAccountFactory();
    BankAccountOwnerXMLSerializationService bankAccountOwnerXMLSerializationService = new BankAccountOwnerXMLSerializationService();
    BankAccountOwnerJsonSerializationService bankAccountOwnerJsonSerializationService = new BankAccountOwnerJsonSerializationService();

    public void run() {
        Customer customer = customerFactory.createCustomer("c-123", "Tomas", "Pesek");
        logger.log(customer.getUuid() + ": " + customer.getFirstName() + " " + customer.getLastName());

        System.out.println(bankAccountOwnerXMLSerializationService.serialize(test));
        System.out.println(bankAccountOwnerJsonSerializationService.serialize(test));

        logger.log("=== TEST BANK ACCOUNT");
        BaseBankAccount account1 = testBankAccount(customer);

        logger.log(account1 instanceof BankAccount ? "Bank" : "Save");

        logger.log("=== TEST SAVE ACCOUNT");
        BaseBankAccount account2 = testSaveAccount(customer);
        logger.log(account2 instanceof  BankAccount ? "Bank" : "Save");

        if (account2 instanceof SaveBankAccount) {
            float interestRate = ((SaveBankAccount)account2).getInterestRate();
            logger.log("Interest Rate: " + interestRate);
        }
    }

    private BaseBankAccount testSaveAccount(Customer customer) {
        BaseBankAccount account = bankAccountFactory.createSaveAccount(
                "u-123",
                customer,
                5
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
