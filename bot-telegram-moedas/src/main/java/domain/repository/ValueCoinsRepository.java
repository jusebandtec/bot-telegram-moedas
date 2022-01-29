package domain.repository;

import domain.responses.CoinsResponse;

public interface ValueCoinsRepository {

    CoinsResponse getAllCoins();
    double getUSD();
    double getEUR();
    double getBTC();
    double getBRL();
    double getBCOIN();
}
