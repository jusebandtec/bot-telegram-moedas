package br.com.obrigado_bomb_crypto.service.cot.coins.framework.http;

import java.time.Duration;

public class HttpResponse {

    private String contentResponse;
    private Duration durationRequest;

    public HttpResponse(String contentResponse, Duration durationRequest) {
        this.contentResponse = contentResponse;
        this.durationRequest = durationRequest;
    }

    public HttpResponse() { }

    public String getContentResponse() {
        return contentResponse;
    }

    public void setContentResponse(String contentResponse) {
        this.contentResponse = contentResponse;
    }

    public Duration getTimeRequestResponse() {
        return durationRequest;
    }

    public void setTimeRequestResponse(Duration timeRequestResponse) {
        this.durationRequest = timeRequestResponse;
    }

}
