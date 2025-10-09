package serialization;

import com.google.gson.Gson;
import com.google.gson.JsonSerializer;
import com.thoughtworks.xstream.XStream;

public class BankAccountOwnerJsonSerializationService implements Serialization
{

    @Override
    public String serialize(Object object)
    {

        Gson gson = new Gson();
        String string = gson.toJson(object);


        /* Object to XML

        stringBuilder.append("<BankAccountOwnerSerialization>");

        stringBuilder.append("<UUID>"+((BankAccountOwnerSerialization) object).getUUID()+"</UUID>");
        stringBuilder.append("<FirstName>"+((BankAccountOwnerSerialization) object).getFirstName()+"</FirstName>");
        stringBuilder.append("<LastName>"+((BankAccountOwnerSerialization) object).getLastName()+"</LastName>");

        stringBuilder.append("</BankAccountOwnerSerialization>");
        */

        return string;

    }




}
