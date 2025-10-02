package Checks;

import java.util.Scanner;

public class BankAccountServiceChecker {

    public void NegativeAmountCheck(double amount, String message){
        if (amount <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public boolean MoreMoneyThenCheck(double amount, double maxAmount){
        if (amount > maxAmount) {
            System.err.println("Amount to be deposited is greater than "+maxAmount+" .");
            return true;
        }
        else{
            return false;
        }
    }

    public String AntiAMLCheck(double amount, double maxAmount)
    {
        Scanner scanner = new Scanner(System.in);

        if(MoreMoneyThenCheck(amount,maxAmount)==true)
        {
            System.out.println("Write the origin of the money");
            return (scanner.nextLine());
        }
        else{
            return(null);
        }

    }

    public void MoneyOnAccountCheck(double balance,double amount)
    {
        if (balance < amount) {
            throw new IllegalStateException("Insufficient funds.");
        }
    }




}
