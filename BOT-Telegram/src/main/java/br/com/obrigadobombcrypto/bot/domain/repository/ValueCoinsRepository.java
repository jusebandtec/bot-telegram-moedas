package br.com.obrigadobombcrypto.bot.domain.repository;

import br.com.obrigadobombcrypto.bot.domain.responses.CoinsResponse;

import java.io.IOException;

public interface ValueCoinsRepository {

    CoinsResponse getAllCoins();
    double getUSD();
    double getEUR();
    double getBTC() throws IOException;
    double getBRL();
    double getBCOIN() throws IOException;
}
