package br.com.obrigadobombcrypto.bot.domain;

public class Coins {

    private double USD;
    private double EUR;
    private double BCOIN;
    private double BTC;
    private double BRL;

    public Coins(double USD, double EUR, double BCOIN, double BTC, double BRL) {
        this.BRL = BRL;
        this.USD = this.BRL / USD;
        this.EUR = this.BRL / EUR;
        this.BCOIN = BCOIN;
        this.BTC = BTC;
    }

    public Coins() { }

    public double getUSD() {
        return USD;
    }

    public void setUSD(double USD) {
        this.USD = USD;
    }

    public double getEUR() {
        return EUR;
    }

    public void setEUR(double EUR) {
        this.EUR = EUR;
    }

    public double getBCOIN() {
        return BCOIN;
    }

    public void setBCOIN(double BCOIN) {
        this.BCOIN = BCOIN;
    }

    public double getBTC() {
        return BTC;
    }

    public void setBTC(double BTC) {
        this.BTC = BTC;
    }

    public double getBRL() {
        return BRL;
    }

    public void setBRL(double BRL) {
        this.BRL = BRL;
    }

    @Override
    public String toString() {

        return String.format
                (
                "%1$s\n" +
                "%2$s\n" +
                "%3$s\n" +
                "%4$s\n" +
                "%5$s",
                        getUSDString(), getEURString(), getBRLString(), getBTCString(), getBCOINString());

    }

    private String getUSDString() {
        return Double.isInfinite(this.USD) ?
                "Não conseguimos trazer o valor da moeda USD" : String.format("USD - R$%1$.4f", this.USD);
    }

    private String getEURString() {
        return Double.isInfinite(this.EUR) ?
                "Não conseguimos trazer o valor da moeda USD" : String.format("EUR - R$%1$.4f", this.EUR);
    }

    private String getBRLString() {
        return Double.isInfinite(this.BRL) ?
                "Não conseguimos trazer o valor da moeda BRL" : String.format("BRL - R$%1$.4f", this.BRL);
    }

    private String getBTCString() {
        return Double.isInfinite(this.BTC) ?
                "Não conseguimos trazer o valor da moeda BTC" : String.format("BTC - R$%1$.4f", this.BTC);
    }

    private String getBCOINString() {
        return Double.isInfinite(this.BCOIN) ?
                "Não conseguimos trazer o valor da moeda BCOIN" : String.format("BCOIN - R$%1$.4f", this.BCOIN);
    }
}
