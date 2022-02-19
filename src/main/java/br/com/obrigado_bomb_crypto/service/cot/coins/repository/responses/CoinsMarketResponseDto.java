package br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses;

import br.com.obrigado_bomb_crypto.service.cot.coins.domain.QuoteCoinMarket;

public class CoinsMarketResponseDto {

    private int id;
    private String name;
    private String symbol;
    private QuoteCoinMarket quote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public QuoteCoinMarket getQuote() {
        return quote;
    }

    public void setQuote(QuoteCoinMarket quote) {
        this.quote = quote;
    }
}
