package br.com.obrigado_bomb_crypto.service.cot.coins.repository;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpConnection;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.*;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.CoinsResponseData;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.ObterTodasMoedasResponseData;
import com.google.gson.Gson;

public class ObterValorMoedasRepository implements br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository.ObterValorMoedasRepository {

    private Gson gson;
    private ObterTodasMoedasResponseData coins;
    private HttpConnection httpConnection;

    public ObterValorMoedasRepository() throws Exception {
        this.gson = new Gson();
        this.httpConnection = new HttpConnection();
        this.coins = makeRequest();
    }

    @Override
    public CoinsResponseData getAllCoins() {
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
    public double getBTC() throws Exception {
        var obterBitcoinRequest = new ObterBitcoinRequest();
        var responseBody = this.httpConnection.doRequest(obterBitcoinRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"1\":{"), "");
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
    public double getBCOIN() throws Exception {
        var obterBcoinRequest = new ObterBcoinRequest();
        var responseBody = this.httpConnection.doRequest(obterBcoinRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"12252\":{"), "");
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
    public double getBCOINinUSD() throws Exception {
        var obterBcoinEmDolarRequest = new ObterBcoinEmUsdRequest();
        var responseBody = this.httpConnection.doRequest(obterBcoinEmDolarRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"12252\":{"), "");
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
    public double getEtherium() throws Exception {
        var obterEtheriumRequest = new ObterEtheriumRequest();
        var responseBody = this.httpConnection.doRequest(obterEtheriumRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"1027\":{"), "");
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
    public double getShibaInu() throws Exception {
        var obterShinaIbu = new ObterShinaInuRequest();
        var responseBody = this.httpConnection.doRequest(obterShinaIbu);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"5994\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = this.gson.fromJson(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }



    private ObterTodasMoedasResponseData makeRequest() throws Exception {
        var obterMoedasRequest = new ObterPrincipaisMoedasRequest();
        var response = this.httpConnection.doRequest(obterMoedasRequest);
        return this.gson.fromJson(response.getContentResponse(), ObterTodasMoedasResponseData.class);
    }
}
