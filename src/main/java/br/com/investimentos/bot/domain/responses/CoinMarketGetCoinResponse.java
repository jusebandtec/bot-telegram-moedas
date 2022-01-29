package br.com.investimentos.bot.domain.responses;

public class CoinMarketGetCoinResponse {

    private StatusResponseCoinMarket status;
    private CoinsMarketResponseDto data;

    public StatusResponseCoinMarket getStatus() {
        return status;
    }

    public void setStatus(StatusResponseCoinMarket status) {
        this.status = status;
    }

    public CoinsMarketResponseDto getData() {
        return data;
    }

    public void setData(CoinsMarketResponseDto data) {
        this.data = data;
    }
}
