package org.example.accounts.factories;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.accounts.BankAccount;
import org.example.accounts.SaveBankAccount;
import org.example.accounts.StudentBankAccount;
import org.example.accounts.generators.BankAccountNumberGenerator;
import org.example.accounts.services.BankAccountService;
import org.example.persons.customers.Customer;

import java.time.LocalDate;
import java.util.Date;

@Singleton
public class BankAccountFactory {

    private final BankAccountNumberGenerator bankAccountNumberGenerator = new BankAccountNumberGenerator();

    @Inject
    private BankAccountService bankAccountService;

    public BankAccount createBankAccount(String uuid, Customer customer) {
        BankAccount bankAccount = new BankAccount(
                uuid,
                bankAccountNumberGenerator.generateRandomAccountNumber(),
                customer
        );
        bankAccountService.BankAccounts.add(bankAccount);
        return bankAccount;
    }

    public SaveBankAccount createSaveAccount(String uuid, Customer customer, float interestRate, LocalDate nextInterestDate, double balance) {
        SaveBankAccount saveBankAccount= new SaveBankAccount(
                uuid,
                bankAccountNumberGenerator.generateRandomAccountNumber(),
                customer,
                interestRate,
                nextInterestDate,
                balance
        );
        bankAccountService.BankAccounts.add(saveBankAccount);
        return saveBankAccount;
    }

    public StudentBankAccount createStudentAccount(String uuid, Customer customer, String schoolName) {
        StudentBankAccount studentBankAccount=new StudentBankAccount(
                uuid,
                bankAccountNumberGenerator.generateRandomAccountNumber(),
                customer,
                schoolName
        );
        bankAccountService.BankAccounts.add(studentBankAccount);
        return studentBankAccount;
    }

}
