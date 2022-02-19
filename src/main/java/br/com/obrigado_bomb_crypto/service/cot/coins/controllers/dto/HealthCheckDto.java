package br.com.obrigado_bomb_crypto.service.cot.coins.controllers.dto;

public class HealthCheckDto {

    private String status;

    public String getStatus() {
        return "OK";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
