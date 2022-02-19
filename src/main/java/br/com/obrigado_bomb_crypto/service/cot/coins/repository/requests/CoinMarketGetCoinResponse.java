package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.CoinsMarketResponseDto;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.StatusResponseCoinMarket;

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
