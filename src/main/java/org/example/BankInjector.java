package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.example.serialization.BankAccountOwnerJsonSerializationService;
import org.example.serialization.BankAccountOwnerXMLSerializationService;
import org.example.serialization.Serialization;

public class BankInjector extends AbstractModule
{
    @Override
    protected void configure()
    {


        bind(Serialization.class)
                .annotatedWith(Names.named("Json"))
                .to(BankAccountOwnerJsonSerializationService.class);

        bind(Serialization.class)
                .annotatedWith(Names.named("XML"))
                .to(BankAccountOwnerXMLSerializationService.class);



    }
}
