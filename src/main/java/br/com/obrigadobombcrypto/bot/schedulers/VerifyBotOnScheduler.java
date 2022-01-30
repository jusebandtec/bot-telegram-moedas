package br.com.obrigadobombcrypto.bot.schedulers;

import lombok.var;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class VerifyBotOnScheduler {

    @Scheduled(fixedRate = 300000)
    public void execute() throws IOException {

        var httpClientRequest = HttpClients.createDefault();
        var httpGet = new HttpGet("https://blooming-reaches-21421.herokuapp.com/v1/health-check");

        ResponseHandler responseHandler = response -> {
            if (response.getStatusLine().getStatusCode() == 200) {
                var entity = response.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            } else {
                throw new ClientProtocolException("Unexpected response status: " + response
                        .getStatusLine()
                        .getStatusCode());
            }
        };

        var responseBody = httpClientRequest.execute(httpGet, responseHandler);
    }
}
