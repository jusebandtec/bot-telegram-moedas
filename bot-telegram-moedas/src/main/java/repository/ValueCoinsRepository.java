package repository;

import com.google.gson.Gson;
import domain.responses.CoinsResponse;
import domain.responses.GetAllCoinsResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ValueCoinsRepository implements domain.repository.ValueCoinsRepository {

    private Gson gson;
    private GetAllCoinsResponse coins;

    public ValueCoinsRepository() throws IOException {
        this.gson = new Gson();
        this.coins = makeRequest();
    }


    private GetAllCoinsResponse makeRequest() throws IOException {

        var httpClientRequest = HttpClients.createDefault();
        var httpGet = new HttpGet("https://v6.exchangerate-api.com/v6/e3584d13af8f66d3fdbfb196/latest/BRL");

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

        return this.gson.fromJson(responseBody.toString(), GetAllCoinsResponse.class);
    }

    @Override
    public CoinsResponse getAllCoins() {
        return this.coins.getConversion_rates();
    }

    @Override
    public double getUSD() {
        return this.coins.getConversion_rates().getUSD();
    }

    @Override
    public double getEUR() {
        return this.coins.getConversion_rates().getEUR();
    }

    @Override
    public double getBTC() {
        return 0;
    }

    @Override
    public double getBRL() {
        return this.coins.getConversion_rates().getBRL();
    }

    @Override
    public double getBCOIN() {
        return 0;
    }
}
