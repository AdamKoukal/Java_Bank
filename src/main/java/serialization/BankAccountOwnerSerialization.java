package serialization;

import People.BankAccountOwner;
import People.Human;

public class BankAccountOwnerSerialization extends Human
{

    private String uUID;

    private String firstName;

    private String lastName;

    public BankAccountOwnerSerialization(String uUID, String firstName, String lastName)
    {
        super(uUID, firstName, lastName);
    }



}
