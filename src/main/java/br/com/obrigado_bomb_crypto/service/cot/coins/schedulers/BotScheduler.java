package br.com.obrigado_bomb_crypto.service.cot.coins.schedulers;

import br.com.obrigado_bomb_crypto.service.cot.coins.domain.services.ServiceImage;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.ObterGraficoRepository;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.ObterValorMoedasRepository;
import br.com.obrigado_bomb_crypto.service.cot.coins.services.EchoBotService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.text.DecimalFormat;

@AllArgsConstructor
@Component
public class BotScheduler {

    private ObterValorMoedasRepository obterValorMoedasRepository;
    private ObterGraficoRepository obterGraficoRepository;
    private ServiceImage serviceImage;

    @Scheduled(fixedRate = 3600000)
    public void execute() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new EchoBotService(obterValorMoedasRepository, obterGraficoRepository, serviceImage));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 120000)
    public void sendDataApiGrafico() throws Exception {
        var bcoin = this.obterValorMoedasRepository.getBcoinBrl();
        DecimalFormat df =  new DecimalFormat();
        df.setMaximumFractionDigits(2);
        var bcoinString = df.format(bcoin).replace(",",".");
        this.obterGraficoRepository.postarDadosGrafico(Double.parseDouble(bcoinString));
    }
}
