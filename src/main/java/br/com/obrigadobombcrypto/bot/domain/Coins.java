package br.com.obrigadobombcrypto.bot.domain;

import lombok.var;

import java.text.DecimalFormat;

public class Coins {

    private double USD;
    private double EUR;
    private double BCOIN;
    private double BTC;
    private double BRL;
    private double BCOINTOUSD;
    private double ETHEREUM;
    private double shibaInu;

    public Coins(double USD, double EUR, double BCOIN, double BTC, double BRL, double BCOINTOUSD, double ethereum, double shibaInu) {
        this.BRL = BRL;
        this.USD = this.BRL / USD;
        this.EUR = this.BRL / EUR;
        this.BCOIN = BCOIN;
        this.BTC = BTC;
        this.BCOINTOUSD = BCOINTOUSD;
        this.ETHEREUM = ethereum;
        this.shibaInu = shibaInu;
    }

    public Coins(double valor, double BCOIN, double BRL) {
        this.BCOIN = valor * BCOIN;
        this.BRL = this.BCOIN * BRL;
    }

    public Coins() { }

    public double getETHEREUM() {
        return ETHEREUM;
    }

    public void setETHEREUM(double ETHEREUM) {
        this.ETHEREUM = ETHEREUM;
    }

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

    public double getShibaInu() {
        return shibaInu;
    }

    public void setShibaInu(double shibaInu) {
        this.shibaInu = shibaInu;
    }

    @Override
    public String toString() {

        return String.format
                (
                "%1$s\n" +
                "%2$s\n" +
                "%3$s\n" +
                "%4$s\n" +
                "%5$s\n" +
                "%6$s",

                getBCOINString(),
                getUSDString(),
                getEURString(),
                getBTCString(),
                getETHERIUMString(),
                getShibaInuString());

    }

    public String enviarMensagemTelegram(String nome, int valor) {
        return String.format("Olá, %1$s, você tem %2$d BCOIN's que valem:\n\nR$ %3$.2f \nUSD %4$.2f", nome, valor, this.BRL, this.BCOIN);
    }

    private String getUSDString() {
        return Double.isInfinite(this.USD) ?
                "Não conseguimos trazer o valor da moeda USD" : String.format("USD - R$%1$.2f", this.USD);
    }

    private String getEURString() {
        return Double.isInfinite(this.EUR) ?
                "Não conseguimos trazer o valor da moeda EUR" : String.format("EUR - R$%1$.2f", this.EUR);
    }

    private String getBRLString() {
        return Double.isInfinite(this.BRL) ?
                "Não conseguimos trazer o valor da moeda BRL" : String.format("BRL - R$%1$.2f", this.BRL);
    }

    private String getBTCString() {
        return Double.isInfinite(this.BTC) ?
                "Não conseguimos trazer o valor da moeda BTC" : String.format("BTC - R$%1$.2f", this.BTC);
    }

    private String getBCOINString() {
        return Double.isInfinite(this.BCOIN) ?
                "Não conseguimos trazer o valor da moeda BCOIN" : String.format("BCOIN - R$%1$.2f", this.BCOIN);
    }

    private String getETHERIUMString() {
        return Double.isInfinite(this.getETHEREUM()) ?
                "Não conseguimos trazer o valor da moeda ETHERIUM" : String.format("ETH - R$%1$.2f", this.getETHEREUM());
    }

    private String getShibaInuString() {
        DecimalFormat format = new DecimalFormat("0.00000000000");
        var shibainu = format.format(this.getShibaInu());
        return Double.isInfinite(this.getShibaInu()) ?
                "Não conseguimos trazer o valor da moeda Shiba Inu" : String.format("SHIB - R$%1$s", shibainu);
    }
}
