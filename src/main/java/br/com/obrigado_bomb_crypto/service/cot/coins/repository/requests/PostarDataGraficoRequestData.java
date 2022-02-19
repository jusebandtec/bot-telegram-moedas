package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

public class PostarDataGraficoRequestData {

    private double data;

    public PostarDataGraficoRequestData(double data) {
        this.data = data;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }
}
