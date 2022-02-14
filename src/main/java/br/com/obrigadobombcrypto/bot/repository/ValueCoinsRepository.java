package br.com.obrigadobombcrypto.bot.repository;

import br.com.obrigadobombcrypto.bot.domain.responses.CoinMarketGetCoinResponse;
import br.com.obrigadobombcrypto.bot.domain.responses.CoinsResponse;
import br.com.obrigadobombcrypto.bot.domain.responses.GetAllCoinsResponse;
import com.google.gson.Gson;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import lombok.var;

import java.io.IOException;
import java.text.DecimalFormat;

public class ValueCoinsRepository implements br.com.obrigadobombcrypto.bot.domain.repository.ValueCoinsRepository {

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
    public double getBTC() throws IOException {
        var httpClientRequest = HttpClients.createDefault();
        var httpGet = new HttpGet("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1&convert=BRL");
        httpGet.setHeader("header-name","header-value");

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
        var responseBodyString = responseBody.toString().replace(String.valueOf("\"1\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = this.gson.fromJson(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

    @Override
    public double getBRL() {
        return this.coins.getConversion_rates().getBRL();
    }

    @Override
    public double getBCOIN() throws IOException {
        var httpClientRequest = HttpClients.createDefault();
        var httpGet = new HttpGet("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=12252&convert=BRL");
        httpGet.setHeader("header-name","header-value");

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
        var responseBodyString = responseBody.toString().replace(String.valueOf("\"12252\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = this.gson.fromJson(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

    @Override
    public double getBCOINinUSD() throws IOException {
        var httpClientRequest = HttpClients.createDefault();
        var httpGet = new HttpGet("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=12252&convert=USD");
        httpGet.setHeader("header-name","header-value");

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
        var responseBodyString = responseBody.toString().replace(String.valueOf("\"12252\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = this.gson.fromJson(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getUSD()
                .getPrice();
    }

    @Override
    public double getEtherium() throws IOException {
        var httpClientRequest = HttpClients.createDefault();
        var httpGet = new HttpGet("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=1027&convert=BRL");
        httpGet.setHeader("header-name","header-value");

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
        var responseBodyString = responseBody.toString().replace(String.valueOf("\"1027\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = this.gson.fromJson(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

    @Override
    public double getShibaInu() throws IOException {
        var httpClientRequest = HttpClients.createDefault();
        var httpGet = new HttpGet("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=5994&convert=BRL");
        httpGet.setHeader("header-name","header-value");

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
        var responseBodyString = responseBody.toString().replace(String.valueOf("\"5994\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = this.gson.fromJson(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

}
