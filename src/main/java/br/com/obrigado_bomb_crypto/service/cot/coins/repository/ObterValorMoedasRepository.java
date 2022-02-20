package br.com.obrigado_bomb_crypto.service.cot.coins.repository;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpConnection;
import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRepository;
import br.com.obrigado_bomb_crypto.service.cot.coins.infraestructure.JsonHelper;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.*;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.CoinsResponseData;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.ObterTodasMoedasResponseData;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ObterValorMoedasRepository extends HttpRepository implements br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository.ObterValorMoedasRepository {

    private ObterTodasMoedasResponseData coins;

    @Override
    public CoinsResponseData getAllCoins() throws Exception {
        this.coins = makeRequest();
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
        var responseBody = this.getHttpConnection().doRequest(obterBitcoinRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"1\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
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
    public double getBcoinBrl() throws Exception {
        var obterBcoinRequest = new ObterBcoinRequest();
        var responseBody = this.getHttpConnection().doRequest(obterBcoinRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"12252\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

    @Override
    public double getBcoinUsd() throws Exception {
        var obterBcoinEmDolarRequest = new ObterBcoinEmUsdRequest();
        var responseBody = this.getHttpConnection().doRequest(obterBcoinEmDolarRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"12252\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getUSD()
                .getPrice();
    }

    @Override
    public double getEtherium() throws Exception {
        var obterEtheriumRequest = new ObterEtheriumRequest();
        var responseBody = this.getHttpConnection().doRequest(obterEtheriumRequest);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"1027\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

    @Override
    public double getShibaInuBrl() throws Exception {
        var obterShinaIbu = new ObterShinaInuBrlRequest();
        var responseBody = this.getHttpConnection().doRequest(obterShinaIbu);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"5994\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

    @Override
    public double getShibaInuUsd() throws Exception {
        var obterShinaIbuUsd = new ObterShinaInuUsdRequest();
        var responseBody = this.getHttpConnection().doRequest(obterShinaIbuUsd);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"5994\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getUSD()
                .getPrice();
    }

    @Override
    public double getSpeBrl() throws Exception {
        var obteSpe = new ObterSpeBrlRequest();
        var responseBody = this.getHttpConnection().doRequest(obteSpe);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"18149\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getBRL()
                .getPrice();
    }

    @Override
    public double getSpeUsd() throws Exception {
        var obteSpeUsd = new ObterSpeUsdRequest();
        var responseBody = this.getHttpConnection().doRequest(obteSpeUsd);
        var responseBodyString = responseBody.getContentResponse().replace(String.valueOf("\"18149\":{"), "");
        var stringBuffer = new StringBuffer(responseBodyString);
        stringBuffer.deleteCharAt(responseBodyString.length()-1);
        var response = new JsonHelper<CoinMarketGetCoinResponse>().deserializeFromString(stringBuffer.toString(), CoinMarketGetCoinResponse.class);
        return response
                .getData()
                .getQuote()
                .getUSD()
                .getPrice();
    }


    private ObterTodasMoedasResponseData makeRequest() throws Exception {
        var obterMoedasRequest = new ObterPrincipaisMoedasRequest();
        var response = this.getHttpConnection().doRequest(obterMoedasRequest);
        return new JsonHelper<ObterTodasMoedasResponseData>().deserializeFromString(response.getContentResponse(), ObterTodasMoedasResponseData.class);
    }
}
