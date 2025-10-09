package org.example.serialization;

import com.thoughtworks.xstream.XStream;

public class BankAccountOwnerXMLSerializationService implements Serialization
{
    @Override
    public String serialize(Object object)
    {

        XStream xstream = new XStream();

        String string = xstream.toXML(object);

        return string;

    }





}
