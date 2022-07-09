package com.dreamteam.debtsreminderbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Send {

    @Autowired
    private Bot bot;

    @Scheduled(cron = "*/1 * * * *")
    public void sen() {
        bot.sendMsg("123", "add");
        System.out.println("sent message = add");
    }
}
