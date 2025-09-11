package org.example;

import BankAccounts.BankAccount;
import BankAccounts.BaseBankAccount;
import People.BankAccountOwner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BankAccountOwner AccountOwner = new BankAccountOwner("adas","Pepa","Novák");

        System.out.println(AccountOwner.getFirstName());
        BaseBankAccount BankAccount =new BaseBankAccount("aaa","wqweqwe",AccountOwner,100.1);
        BaseBankAccount SavingAccount =new BankAccount("aaa","wqweqwe",AccountOwner,100.1);




        System.out.println(AccountOwner.getFirstName()+" "+AccountOwner.getLastName());
        System.out.println(BankAccount.getBalance()+"$");

        BankAccount.addBalance(100);
        System.out.println(BankAccount.getBalance()+"$");
        BankAccount.removeBalance(50);
        System.out.println(BankAccount.getBalance()+"$");
        BankAccount.removeBalance(200);

    }
}