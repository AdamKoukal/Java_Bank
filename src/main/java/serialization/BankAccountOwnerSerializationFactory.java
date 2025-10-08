package serialization;

import People.BankAccountOwner;
import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;

public class BankAccountOwnerSerializationFactory implements Serialization
{
    public BankAccountOwnerSerialization createBankAccountOwnerSerialization(String UUID, String FirstName, String LastName){
        return new BankAccountOwnerSerialization(UUID, FirstName, LastName);
    }
    @Override
    public String serialize(Object object)
    {
        StringBuilder stringBuilder = new StringBuilder();


        //Gson gson = new Gson();
        //gson.toJson(new BankAccountOwnerSerialization("asd1","1","a"));

        stringBuilder.append("<BankAccountOwnerSerialization>");

        stringBuilder.append("<UUID>"+((BankAccountOwnerSerialization) object).getUUID()+"</UUID>");
        stringBuilder.append("<FirstName>"+((BankAccountOwnerSerialization) object).getFirstName()+"</FirstName>");
        stringBuilder.append("<LastName>"+((BankAccountOwnerSerialization) object).getLastName()+"</LastName>");
        //object.getClass().
        stringBuilder.append("</BankAccountOwnerSerialization>");

        return stringBuilder.toString();

    }


}
