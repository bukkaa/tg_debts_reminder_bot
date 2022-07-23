package com.bukkaa.tg.debts_reminder_bot.ri.bot_client.commands;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.helpCommand.ManCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static java.lang.String.format;

@Slf4j
public class StartCommand extends ManCommand {


    public StartCommand() {
        super("start", "Starts the bot", "Launches this crazy boy rollin'!");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        String text = format("Hey, %s!\nLet's get rollin'! So who's own you some?" +
                " And use /help to learn more tricks!", StringUtils.defaultString(user.getUserName(), "sir " + user.getFirstName() + " " + user.getLastName()));

        SendMessage message = new SendMessage();
        //включаем поддержку режима разметки, чтобы управлять отображением текста и добавлять эмодзи
        message.enableMarkdown(true);
        message.setChatId(chat.getId().toString());
        message.setText(text);
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            log.error("Unexpected exception while sending answer back.", e);
        }
    }


    @Override
    public String toString() {
        return "StartCommand {commandIdentifier = 'start', description = 'Starts the bot'," +
                " extendedDescription = 'Launches this crazy boy rollin'!'}";
    }
}
