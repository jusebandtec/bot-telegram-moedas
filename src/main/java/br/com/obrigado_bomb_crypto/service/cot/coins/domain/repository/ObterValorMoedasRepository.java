package br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository;

import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.CoinsResponseData;

import java.io.IOException;

public interface ObterValorMoedasRepository {

    CoinsResponseData getAllCoins();
    double getUSD();
    double getEUR();
    double getBTC() throws Exception;
    double getBRL();
    double getBcoinBrl() throws Exception;
    double getBcoinUsd() throws Exception;
    double getEtherium() throws Exception;
    double getShibaInuBrl() throws Exception;
    double getShibaInuUsd() throws Exception;
    double getSpeBrl() throws Exception;
    double getSpeUsd() throws Exception;
}
