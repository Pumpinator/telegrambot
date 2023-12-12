package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "PumpinatorBot_bot";
    public static final String TOKEN = "6762709434:AAGIGWU5gU3qQq9bLCdMd1dSwNIxREnFJDw";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        String messageText = getMessageText().toLowerCase();
        if (messageText.equals("/start")) {
            sendTextMessageAsync("¡Hola, amante de las pesas y los fierros!");
        }
        if (messageText.contains("hola")) {
            sendTextMessageAsync("Hola, ¿Cúal es tu nombre?");
        }
        if (messageText.contains("me llamo")) {
            sendTextMessageAsync("Encantado de conocerte, yo soy - *Gato*");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}