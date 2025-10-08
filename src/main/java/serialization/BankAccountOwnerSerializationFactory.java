package serialization;

import People.BankAccountOwner;
import com.google.gson.Gson;
//import jakarta.xml.bind.JAXBContext;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.thoughtworks.xstream.XStream;

import java.io.Console;

public class BankAccountOwnerSerializationFactory implements Serialization
{
    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(String UUID, String FirstName, String LastName){
        return new BankAccountOwnerSerialization(UUID, FirstName, LastName);
    }
    @Override
    public String serialize(Object object)
    {
        StringBuilder stringBuilder = new StringBuilder();

        BankAccountOwnerSerialization test = createBankAccountOwnerSerialization("asdd","1","2");

        //Gson gson = new Gson();
        //String string=gson.toJson(test);

        XStream xstream = new XStream();


        String string =xstream.toXML(test);
        /* Object to XML

        stringBuilder.append("<BankAccountOwnerSerialization>");

        stringBuilder.append("<UUID>"+((BankAccountOwnerSerialization) object).getUUID()+"</UUID>");
        stringBuilder.append("<FirstName>"+((BankAccountOwnerSerialization) object).getFirstName()+"</FirstName>");
        stringBuilder.append("<LastName>"+((BankAccountOwnerSerialization) object).getLastName()+"</LastName>");

        stringBuilder.append("</BankAccountOwnerSerialization>");
        */

        return string;//string/*Builder.toString()*/;

    }


}
