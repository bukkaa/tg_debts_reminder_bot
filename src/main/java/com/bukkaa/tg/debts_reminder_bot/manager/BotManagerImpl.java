package com.bukkaa.tg.debts_reminder_bot.manager;

import com.bukkaa.tg.debts_reminder_bot.ri.bot_client.BotClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BotManagerImpl implements BotManager {

    private final BotClient botClient;

    @Override
    public Optional<Message> sendMessage(String chatId, String message) {
        return botClient.sendMessage(chatId, SendMessage.builder()
                                                        .chatId(chatId)
                                                        .text(message)
                                                        .build());
    }
}
