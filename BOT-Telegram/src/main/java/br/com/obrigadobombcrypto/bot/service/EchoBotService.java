package br.com.obrigadobombcrypto.bot.service;

import br.com.obrigadobombcrypto.bot.domain.Bot;
import br.com.obrigadobombcrypto.bot.domain.Coins;
import br.com.obrigadobombcrypto.bot.repository.ValueCoinsRepository;
import lombok.var;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;


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
    public void onRegister() {
        try {
            var mensagem = sendMessage();
            execute(mensagem);
        } catch (TelegramApiException | IOException ex) {
            ex.printStackTrace();
        }
        onClosing();
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            var mensagem = sendMessage();
            execute(mensagem);
        } catch (TelegramApiException | IOException ex) {
            ex.printStackTrace();
        }
    }

    private SendMessage sendMessage() throws IOException {

        return SendMessage.builder()
                .text(ObterMoedas().toString())
                .chatId("-763504639")
                .build();
    }


    private Coins ObterMoedas() throws IOException {

        var valueCoinsRepository = new ValueCoinsRepository();

        return new Coins
            (
                valueCoinsRepository.getUSD(),
                valueCoinsRepository.getEUR(),
                valueCoinsRepository.getBCOIN(),
                valueCoinsRepository.getBTC(),
                valueCoinsRepository.getBRL()
            );
    }

}
