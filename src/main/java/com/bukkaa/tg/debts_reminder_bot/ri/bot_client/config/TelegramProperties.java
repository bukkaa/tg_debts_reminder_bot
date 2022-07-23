package com.bukkaa.tg.debts_reminder_bot.ri.bot_client.config;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "telegram")
public class TelegramProperties {
    String webhookPath;
    String botTitle;
    String botName;
    String botToken;
}
