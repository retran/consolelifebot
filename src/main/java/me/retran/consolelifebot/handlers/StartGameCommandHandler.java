package me.retran.consolelifebot.handlers;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.logging.BotLogger;

import me.retran.consolelifebot.Configuration;
import me.retran.consolelifebot.common.Utils;
import me.retran.consolelifebot.quiz.GameState;

@Singleton
public class StartGameCommandHandler extends CommandHandler {
    private GameState state;

    @Inject
    public StartGameCommandHandler(Configuration configuration, GameState state) {
        super(configuration, "/startgame", "");
        this.state = state;
    }

    @Override
    public void handle(AbsSender sender, Message message) {
        BotLogger.info(Utils.getDisplayName(message.getFrom()), message.getText());
        if (state.getStatus() == GameState.Idle) {
            state.setStatus(GameState.Playing);
        }
    }

}
