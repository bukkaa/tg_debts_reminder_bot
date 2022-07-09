package com.dreamteam.debtsreminderbot.configuration;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "telegram")
public class TelegramConfig {
    private String webhookPath;
    private String botName;
    private String botToken;
}
