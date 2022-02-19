package br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository;

import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.CoinsResponseData;

import java.io.IOException;

public interface ObterValorMoedasRepository {

    CoinsResponseData getAllCoins();
    double getUSD();
    double getEUR();
    double getBTC() throws Exception;
    double getBRL();
    double getBCOIN() throws Exception;
    double getBCOINinUSD() throws Exception;
    double getEtherium() throws Exception;
    double getShibaInu() throws Exception;

}
