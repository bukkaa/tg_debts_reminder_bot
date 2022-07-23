package com.bukkaa.tg.debts_reminder_bot.api;

import com.bukkaa.tg.debts_reminder_bot.manager.BotManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.objects.Message;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/debts-reminder-bot/")
public class BotManagerController {

    private final BotManager botManager;

    @GetMapping("/{chatId}/message")
    public ResponseEntity<Message> sendMessage(@RequestParam String message, @PathVariable String chatId) {
        return ResponseEntity.of(botManager.sendMessage(chatId, message));
    }
}
