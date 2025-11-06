package org.example.Interest;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CronService
{
    @Inject
    private InterestAccountsFacade interestAccountsFacade;

    public void run(){
        Thread Cron = new Thread(() -> interestAccountsFacade.run());
        Cron.start();
    }

}
