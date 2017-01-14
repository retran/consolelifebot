package me.retran.consolelifebot.handlers;

import org.telegram.telegrambots.api.objects.Message;

import me.retran.consolelifebot.common.Configuration;

public abstract class CommandHandler extends Handler {
    protected final Configuration configuration;
    protected final String template;
    protected final String description;

    public CommandHandler(Configuration configuration, String template, String description) {
        this.template = template;
        this.description = description;
        this.configuration = configuration;
    }

    public String getTemplate() {
        return template;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean canHandle(Message message) {
        String text = message.getText();
        if (text == null || text.isEmpty()) {
            return false;
        }

        text = text.toLowerCase().trim().split(" ")[0];
        if (text.contains("@")) {
            text = text.replace("@" + configuration.telegramUserName(), "");
        }

        return getTemplate().equalsIgnoreCase(text);
    }
}
