package org.example.Transactions;

import com.google.gson.Gson;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.example.logger.ConsoleLogger;
import org.example.logger.FileSystemLogger;
import org.example.logger.Logger;
import org.example.serialization.Serialization;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TransactionFacade extends Thread implements Serialization
{
    @Inject
    private TransactionManager transactionManager;


    private Logger fileSystemLogger = new FileSystemLogger();
    private Logger consoleLogger = new ConsoleLogger();

    private ArrayList<Integer> savedTransactions=new ArrayList<>();


    public void run(){
        Path path = Path.of("application.log");
        Gson gson = new Gson();
        List<String> radky = null;
        try {
            radky = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String r : radky)
        {
            savedTransactions.add(gson.fromJson(r,Transaction.class).getID());
        }
        while(true)
        {
            for(int i=0;i<transactionManager.getTransactions().size();i++)
            {
                if(!savedTransactions.contains(transactionManager.getTransactions().get(i).getID()))
                {
                    fileSystemLogger.log(serialize(transactionManager.getTransactions().get(i)));
                    savedTransactions.add(transactionManager.getTransactions().get(i).getID());
                }
            }

            consoleLogger.log("Saved");

            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
    public String serialize(Object object)
    {

        Gson gson = new Gson();
        String string = gson.toJson(object);

        return string;

    }


}
