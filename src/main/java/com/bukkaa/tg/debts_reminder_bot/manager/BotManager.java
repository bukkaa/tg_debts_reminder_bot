package com.bukkaa.tg.debts_reminder_bot.manager;

import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

public interface BotManager {

    Optional<Message> sendMessage(String chatId, String message);
}
