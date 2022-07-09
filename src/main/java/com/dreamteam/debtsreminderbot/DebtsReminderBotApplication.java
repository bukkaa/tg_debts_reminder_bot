package com.dreamteam.debtsreminderbot;

import com.dreamteam.debtsreminderbot.configuration.TelegramConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = TelegramConfig.class)
public class DebtsReminderBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DebtsReminderBotApplication.class, args);
    }
}
