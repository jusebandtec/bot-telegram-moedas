package service;

import domain.Bot;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import repository.ValueCoinsRepository;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class EchoBotService extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return Bot.BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return Bot.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage mensagem = null;
            try {
                mensagem = sendMessage(update);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            try {
                execute(mensagem);
            } catch (TelegramApiException ex) {
                ex.printStackTrace();
            }
        }
    }

    private SendMessage sendMessage(Update update) throws IOException {

        var textoMensagem = update.getMessage().getText().toUpperCase(Locale.ROOT);
        var chatId = update.getMessage().getChatId().toString();

        var valorMoeda = ObterMoeda(textoMensagem);
        var resposta = String.format("1%1$s - R$%2$.4f", textoMensagem, ObterMoeda(textoMensagem));

        if (valorMoeda == -1)
            resposta = "Moeda não encontrada.";
        else if(valorMoeda == 0)
            resposta = "Não conseguimos trazer o valor da moeda";

        return SendMessage.builder()
                .text(resposta)
                .chatId(chatId)
                .build();
    }


    private double ObterMoeda(String textoMensagem) throws IOException {

        ValueCoinsRepository valueCoinsRepository = new ValueCoinsRepository();

        switch (textoMensagem) {
            case "BRL":
                return valueCoinsRepository.getBRL() / valueCoinsRepository.getBRL();
            case "USD":
                return valueCoinsRepository.getBRL() / valueCoinsRepository.getUSD();
            case "EUR":
                return valueCoinsRepository.getBRL() / valueCoinsRepository.getEUR();
            case "BTC":
                return 0;
            case "BCOIN":
                return 0;
            default:
                return -1;
        }
    }

}
