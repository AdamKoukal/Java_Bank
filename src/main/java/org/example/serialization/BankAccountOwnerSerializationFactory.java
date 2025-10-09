package org.example.serialization;

//import jakarta.xml.bind.JAXBContext;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;


public class BankAccountOwnerSerializationFactory
{
    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(String UUID, String FirstName, String LastName){
        return new BankAccountOwnerSerialization(UUID, FirstName, LastName);
    }

}
