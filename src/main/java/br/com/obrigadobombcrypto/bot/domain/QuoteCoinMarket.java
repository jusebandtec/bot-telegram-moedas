package br.com.obrigadobombcrypto.bot.domain;

public class QuoteCoinMarket {

    private ConvertCoin BRL;
    private ConvertCoin USD;
    private ConvertCoin ETHERIUM;
    private ConvertCoin shibaInu;

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

    public ConvertCoin getETHERIUM() {
        return ETHERIUM;
    }

    public void setETHERIUM(ConvertCoin ETHERIUM) {
        this.ETHERIUM = ETHERIUM;
    }

    public ConvertCoin getShibaInu() {
        return shibaInu;
    }

    public void setShibaInu(ConvertCoin shibaInu) {
        this.shibaInu = shibaInu;
    }
}
