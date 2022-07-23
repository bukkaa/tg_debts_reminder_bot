package com.bukkaa.tg.debts_reminder_bot.ri.bot_client;

import com.bukkaa.tg.debts_reminder_bot.ri.bot_client.commands.StartCommand;
import com.bukkaa.tg.debts_reminder_bot.ri.bot_client.config.TelegramProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import static java.lang.String.format;

@Slf4j
@Service
@RequiredArgsConstructor
public class BotClient extends TelegramLongPollingCommandBot {

    private final TelegramProperties properties;


    @Override
    public void processNonCommandUpdate(Update update) {
        log.info("Update received: {}", update);
        Message message = update.getMessage();
        message.getDate();
        val messageDate = Instant.now();

        sendMessage(message.getChatId().toString(), SendMessage.builder()
                .chatId(message.getChatId().toString())
                .text(format("Here is what I received at %s: [%s]", messageDate, message))
                .build());
    }

    public Optional<Message> sendMessage(String chatId, SendMessage message) {
        log.info("Sending message [{}] to chat [{}]...", message, chatId);
        try {
            return Optional.ofNullable(execute(message));
        } catch (TelegramApiException e) {
            log.error("Unexpected exception while sending answer back.", e);
        }
        return Optional.empty();
    }


    @Override
    public void onRegister() {
        super.onRegister();
        register(new StartCommand());
        log.debug("Registered commands: {}", getRegisteredCommands());
    }


    @Override
    public String getBotUsername() {
        return properties.getBotName();
    }

    @Override
    public String getBotToken() {
        return properties.getBotToken();
    }
}
