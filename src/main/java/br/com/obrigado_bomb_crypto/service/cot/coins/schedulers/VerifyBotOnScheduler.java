package br.com.obrigado_bomb_crypto.service.cot.coins.schedulers;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpConnection;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.ObterHealthCheckApiGraficoRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.ObterHealthCheckApiRequest;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VerifyBotOnScheduler {


    private final Logger logger = LoggerFactory.getLogger(VerifyBotOnScheduler.class);

    @Scheduled(fixedRate = 300000)
    public void execute() throws Exception {
        try {
            var httpConnection = new HttpConnection();
            var obterHealthCheckApiRequest = new ObterHealthCheckApiRequest();
            httpConnection.doRequest(obterHealthCheckApiRequest);
            logger.info("API ON - OK");
        } catch (Exception ex) {
            logger.error("API DESLIGADA");
        }
    }

    @Scheduled(fixedRate = 120000)
    public void verifyApiPython() throws Exception {
        try {
            var httpConnection = new HttpConnection();
            var obterHealthCheckApiGraficoRequest = new ObterHealthCheckApiGraficoRequest();
            httpConnection.doRequest(obterHealthCheckApiGraficoRequest);
            logger.info("API GRAFICO ON - OK");
        } catch (Exception ex) {
            logger.error("API DESLIGADA");
        }
    }
}
