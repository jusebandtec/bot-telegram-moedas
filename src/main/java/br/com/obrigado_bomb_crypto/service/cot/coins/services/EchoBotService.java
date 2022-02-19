package br.com.obrigado_bomb_crypto.service.cot.coins.services;

import br.com.obrigado_bomb_crypto.service.cot.coins.domain.Bot;
import br.com.obrigado_bomb_crypto.service.cot.coins.domain.Coins;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.ObterGraficoRepository;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.ObterValorMoedasRepository;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
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
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.getMessage().getText().equals("graph_bcoin")) {
                execute(sendPhoto());
            }
            var mensagem = sendMessage(update);
            execute(mensagem);
        } catch (TelegramApiException | IOException ex) {
            ex.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private SendMessage sendMessage() throws Exception {
        return SendMessage.builder()
                .text(ObterMoedas().toString())
                .chatId("-656768137")
                .build();
    }

    private SendMessage sendMessage(Update update) throws Exception {

        var firstName = update.getMessage().getFrom().getFirstName();

        var moedas = ObterMoedas(Double.parseDouble(update.getMessage().getText()));

        var resposta = moedas.enviarMensagemTelegram(firstName, Integer.parseInt(update.getMessage().getText()));

        return SendMessage.builder()
                .text(resposta)
                .chatId("-656768137")
                .build();

    }

    private SendPhoto sendPhoto() throws Exception {

        var serviceImage = new ServiceImage();
        var obterGraficoRepository = new ObterGraficoRepository();

        serviceImage.saveImgBase64(obterGraficoRepository.obterDadosGrafico().getData());

        SendPhoto sendPhotoRequest = new SendPhoto();
        sendPhotoRequest.setChatId("-656768137");
        sendPhotoRequest.setPhoto(new InputFile(new File("grafico.png")));

        return sendPhotoRequest;
    }


    private Coins ObterMoedas() throws Exception {

        var valueCoinsRepository = new ObterValorMoedasRepository();

        return new Coins
            (
                valueCoinsRepository.getUSD(),
                valueCoinsRepository.getEUR(),
                valueCoinsRepository.getBCOIN(),
                valueCoinsRepository.getBTC(),
                valueCoinsRepository.getBRL(),
                valueCoinsRepository.getBCOINinUSD(),
                valueCoinsRepository.getEtherium(),
                valueCoinsRepository.getShibaInu()
            );
    }

    private Coins ObterMoedas(double valor) throws Exception {

        var moedas = ObterMoedas();

        return new Coins(valor, moedas.getBCOINTOUSD(), moedas.getUSD());

    }

}
