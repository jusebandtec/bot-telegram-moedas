package application;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import service.EchoBotService;

import java.io.IOException;

public class RunBot {
    public static void main(String[] args) {

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new EchoBotService());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
