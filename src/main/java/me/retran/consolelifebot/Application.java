package me.retran.consolelifebot;

import com.google.inject.Guice;
import com.google.inject.Injector;
import me.retran.consolelifebot.common.MessagesHandler;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Application {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DependencyRoot());
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(injector.getInstance(MessagesHandler.class));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
