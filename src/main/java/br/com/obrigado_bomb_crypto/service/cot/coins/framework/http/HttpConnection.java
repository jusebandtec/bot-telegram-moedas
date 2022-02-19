package br.com.obrigado_bomb_crypto.service.cot.coins.framework.http;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.Instant;

public class HttpConnection {

    private HttpClient httpClient;

    public HttpConnection() {
        this.httpClient = HttpClient.newBuilder().build();
    }

    public br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpResponse doRequest(HttpRequest httpRequestFinoban) throws Exception {

        Instant start = Instant.now();
        java.net.http.HttpRequest httpRequest = null;
        HttpResponse<?> httpResponse = null;

        if (httpRequestFinoban.getHeaders() != null) {
            var chave = new String();
            var valor = new String();
            for (var header : httpRequestFinoban.getHeaders().entrySet()) {
                chave = header.getKey();
                valor = header.getValue().toString();
            }

            var uri = URI.create(httpRequestFinoban.getUriRelative());

            if (httpRequestFinoban.getHttpMethod() == HttpMethod.GET) {

                var httpClientRequest = HttpClients.createDefault();
                var httpGet = new HttpGet(httpRequestFinoban.getUriRelative());
                ResponseHandler responseHandler = response -> {
                    if (response.getStatusLine().getStatusCode() == 200) {
                        var entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + response
                                .getStatusLine()
                                .getStatusCode());
                    }
                };

                var responseBody = httpClientRequest.execute(httpGet, responseHandler);
                Instant end = Instant.now();
                return new br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpResponse(responseBody.toString(), Duration.between(start, end));

            } else if (httpRequestFinoban.getHttpMethod() == HttpMethod.POST) {
                httpRequest = java.net.http.HttpRequest.newBuilder()
                        .uri(uri)
                        .header(chave, valor)
                        .POST(java.net.http.HttpRequest.BodyPublishers.ofString(httpRequestFinoban.getPayload()))
                        .build();
                httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            }
            else {
                throw new Exception();
            }
        }

        Instant end = Instant.now();
        return new br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpResponse(httpResponse.body().toString(), Duration.between(start, end));
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
}
