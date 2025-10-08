package serialization;

import People.BankAccountOwner;
import People.Human;

public class BankAccountOwnerSerialization extends Human
{

    private String UUID;

    private String FirstName;

    private String LastName;

    public BankAccountOwnerSerialization(String UUID, String FirstName, String LastName)
    {
        super(UUID, FirstName, LastName);
    }



}
