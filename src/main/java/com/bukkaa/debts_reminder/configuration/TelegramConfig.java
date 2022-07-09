package com.bukkaa.debts_reminder.configuration;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "telegram")
public class TelegramConfig {
    private String webhookPath;
    private String botTitle;
    private String botName;
    private String botToken;
}
