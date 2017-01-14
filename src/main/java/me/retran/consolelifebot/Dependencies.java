package me.retran.consolelifebot;

import javax.inject.Singleton;

import dagger.Component;
import me.retran.consolelifebot.common.Configuration;
import me.retran.consolelifebot.common.MessagesHandler;
import me.retran.consolelifebot.quiz.GameProcess;
import me.retran.consolelifebot.youtube.YouTubePoller;

@Singleton
@Component(modules = ApplicationModule.class)
interface Dependencies {
    MessagesHandler messagesHandler();

    YouTubePoller youTubePoller();

    GameProcess gameProcess();

    Configuration configuration();
}