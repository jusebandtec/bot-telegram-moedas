package br.com.obrigadobombcrypto.bot.domain.dto;

public class HealthCheckDto {

    private String status;

    public String getStatus() {
        return "OK";
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
