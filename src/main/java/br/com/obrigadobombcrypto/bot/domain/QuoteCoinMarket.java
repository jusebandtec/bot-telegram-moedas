package br.com.obrigadobombcrypto.bot.domain;

public class QuoteCoinMarket {

    private ConvertCoin BRL;
    private ConvertCoin USD;

    public ConvertCoin getBRL() {
        return BRL;
    }

    public void setBRL(ConvertCoin BRL) {
        this.BRL = BRL;
    }

    public ConvertCoin getUSD() {
        return USD;
    }

    public void setUSD(ConvertCoin USD) {
        this.USD = USD;
    }
}
