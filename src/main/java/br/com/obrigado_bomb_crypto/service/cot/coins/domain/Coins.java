package br.com.obrigado_bomb_crypto.service.cot.coins.domain;

import java.text.DecimalFormat;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;

public class Coins {

    private double USD;
    private double EUR;
    private double bcoinBrl;
    private double bcoinUsd;
    private double BTC;
    private double BRL;
    private double ETHEREUM;
    private double shibaInuBrl;
    private double shibaInuUsd;
    private double speBrl;
    private double speUsd;

    public Coins(double USD, double EUR, double bcoinBrl, double BTC, double BRL, double bcoinUsd, double ethereum, double shibaInuBrl, double shibaInuUsd, double speBrl, double speUsd) {
        this.BRL = BRL;
        this.USD = this.BRL / USD;
        this.EUR = this.BRL / EUR;
        this.bcoinBrl = bcoinBrl;
        this.bcoinUsd = bcoinUsd;
        this.BTC = BTC;
        this.ETHEREUM = ethereum;
        this.shibaInuBrl = shibaInuBrl;
        this.shibaInuUsd = shibaInuUsd;
        this.speBrl = speBrl;
        this.speUsd = speUsd;
    }

    public Coins(double valor, double bcoinBrl, double BRL) {
        this.bcoinBrl = valor * bcoinBrl;
        this.BRL = this.bcoinBrl * BRL;
    }

    public Coins() { }

    public double getETHEREUM() {
        return ETHEREUM;
    }

    public void setETHEREUM(double ETHEREUM) {
        this.ETHEREUM = ETHEREUM;
    }

    public double getBcoinUsd() {
        return bcoinUsd;
    }

    public void setBcoinUsd(double bcoinUsd) {
        this.bcoinUsd = bcoinUsd;
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

    public double getBcoinBrl() {
        return bcoinBrl;
    }

    public void setBcoinBrl(double bcoinBrl) {
        this.bcoinBrl = bcoinBrl;
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

    public double getShibaInuBrl() {
        return shibaInuBrl;
    }

    public void setShibaInuBrl(double shibaInuBrl) {
        this.shibaInuBrl = shibaInuBrl;
    }

    public double getSpeBrl() {
        return speBrl;
    }

    public void setSpeBrl(double speBrl) {
        this.speBrl = speBrl;
    }

    public double getSpeUsd() {
        return speUsd;
    }

    public void setSpeUsd(double speUsd) {
        this.speUsd = speUsd;
    }

    public double getShibaInuUsd() {
        return shibaInuUsd;
    }

    public void setShibaInuUsd(double shibaInuUsd) {
        this.shibaInuUsd = shibaInuUsd;
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
                "%6$s\n" +
                "%7$s",

                getBCOINString(),
                getUSDString(),
                getEURString(),
                getBTCString(),
                getETHERIUMString(),
                getSpeString(),
                getShibaInuString());

    }

    public String enviarMensagemTelegram(String nome, int valor, String moeda) {

        switch (moeda.toLowerCase(Locale.ROOT)) {
            case "bcoin":
                var bcoinDict= converterBcoinParaBrleUsd(valor);
                return String.format("Olá, %1$s, você tem %2$d BCOIN's que valem:\n\nR$ %3$.2f \nUSD %4$.2f", nome, valor, bcoinDict.get("bcoin-brl"), bcoinDict.get("bcoin-usd"));
            case "spe":
                var speDict = converterSpeParaBrleUsd(valor);
                return String.format("Olá, %1$s, você tem %2$d SPE's que valem:\n\nR$ %3$.2f \nUSD %4$.2f", nome, valor, speDict.get("spe-brl"), speDict.get("spe-usd"));
            case "shib":
                var shibDict = converterShibParaBrleUsd(valor);
                return String.format("Olá, %1$s, você tem %2$d SHIB's que valem:\n\nR$ %3$.5f \nUSD %4$.5f", nome, valor, shibDict.get("shib-brl"), shibDict.get("shib-usd"));
            default:
                return "Não foi possível computar moeda";
        }
    }

    private Dictionary converterBcoinParaBrleUsd(int valor) {
        return new Hashtable(){{
            put("bcoin-brl", getBcoinBrl() * valor);
            put("bcoin-usd", getBcoinUsd() * valor);
        }};
    }

    private Dictionary converterSpeParaBrleUsd(int valor) {
        return new Hashtable(){{
            put("spe-brl", getSpeBrl() * valor);
            put("spe-usd", getSpeUsd() * valor);
        }};
    }

    private Dictionary converterShibParaBrleUsd(int valor) {
        return new Hashtable(){{
           put("shib-brl", getShibaInuBrl() * valor);
           put("shib-usd", getShibaInuUsd() * valor);
        }};
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
        return Double.isInfinite(this.bcoinBrl) ?
                "Não conseguimos trazer o valor da moeda BCOIN" : String.format("BCOIN - R$%1$.2f", this.bcoinBrl);
    }

    private String getETHERIUMString() {
        return Double.isInfinite(this.getETHEREUM()) ?
                "Não conseguimos trazer o valor da moeda ETHERIUM" : String.format("ETH - R$%1$.2f", this.getETHEREUM());
    }

    private String getShibaInuString() {
        DecimalFormat format = new DecimalFormat("0.00000000000");
        var shibainu = format.format(this.getShibaInuBrl());
        return Double.isInfinite(this.getShibaInuBrl()) ?
                "Não conseguimos trazer o valor da moeda Shiba Inu" : String.format("SHIB - R$%1$s", shibainu);
    }

    private String getSpeString() {
        return Double.isInfinite(this.getETHEREUM()) ?
                "Não conseguimos trazer o valor da moeda SPE" : String.format("SPE - R$%1$.2f", this.getSpeBrl());
    }
}
