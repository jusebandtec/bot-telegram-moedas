package br.com.obrigado_bomb_crypto.service.cot.coins.schedulers;

import br.com.obrigado_bomb_crypto.service.cot.coins.repository.ObterGraficoRepository;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.ObterValorMoedasRepository;
import br.com.obrigado_bomb_crypto.service.cot.coins.services.EchoBotService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.text.DecimalFormat;

@Component
public class BotScheduler {

    @Scheduled(fixedRate = 3600000)
    public void execute() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new EchoBotService());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 120000)
    public void sendDataApiGrafico() throws Exception {
        var valueCoinsRepository = new ObterValorMoedasRepository();
        var obterGraficoRepository = new ObterGraficoRepository();

        var bcoin = valueCoinsRepository.getBCOIN();
        DecimalFormat df =  new DecimalFormat();
        df.setMaximumFractionDigits(2);
        var bcoinString = df.format(bcoin).replace(",",".");
        obterGraficoRepository.postarDadosGrafico(Double.parseDouble(bcoinString));
    }
}
