package br.com.obrigadobombcrypto.bot.domain;

public class Coins {

    private double USD;
    private double EUR;
    private double BCOIN;
    private double BTC;
    private double BRL;
    private double BCOINTOUSD;

    public Coins(double USD, double EUR, double BCOIN, double BTC, double BRL, double BCOINTOUSD) {
        this.BRL = BRL;
        this.USD = this.BRL / USD;
        this.EUR = this.BRL / EUR;
        this.BCOIN = BCOIN;
        this.BTC = BTC;
        this.BCOINTOUSD = BCOINTOUSD;
    }

    public Coins(double valor, double BCOIN, double BRL) {
        this.BCOIN = valor * BCOIN;
        this.BRL = this.BCOIN * BRL;
    }

    public Coins() { }

    public double getBCOINTOUSD() {
        return BCOINTOUSD;
    }

    public void setBCOINTOUSD(double BCOINTOUSD) {
        this.BCOINTOUSD = BCOINTOUSD;
    }

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
                "%4$s",
                        getBCOINString(), getUSDString(), getEURString(), getBTCString());

    }

    public String enviarMensagemTelegram(String nome, double valor) {
        return String.format("Olá, %1$s, você tem %2$s BCOIN's que valem:\nR$ %3$.4f \nUSD %4$.4f", nome, valor, this.BRL, this.BCOIN);
    }

    private String getUSDString() {
        return Double.isInfinite(this.USD) ?
                "Não conseguimos trazer o valor da moeda USD" : String.format("USD - R$%1$.4f", this.USD);
    }

    private String getEURString() {
        return Double.isInfinite(this.EUR) ?
                "Não conseguimos trazer o valor da moeda EUR" : String.format("EUR - R$%1$.4f", this.EUR);
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
