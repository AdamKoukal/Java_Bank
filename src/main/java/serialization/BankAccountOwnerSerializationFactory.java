package serialization;

import People.BankAccountOwner;
import com.google.gson.Gson;
//import jakarta.xml.bind.JAXBContext;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.thoughtworks.xstream.XStream;

import java.io.Console;

public class BankAccountOwnerSerializationFactory
{
    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(String UUID, String FirstName, String LastName){
        return new BankAccountOwnerSerialization(UUID, FirstName, LastName);
    }
    
}
