package br.com.obrigado_bomb_crypto.service.cot.coins.framework.http;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.Map;

public class HttpRequest {

    private String uriRelative;
    private Map<String, MediaType> stringMediaTypeMap;
    private Map<String, String> headers;
    private String payload;
    private HttpMethod httpMethod;

    public HttpRequest(String uriRelative, Map<String, MediaType> stringMediaTypeMap, String payload, HttpMethod httpMethod, Map<String, String> headers) {
        this.uriRelative = uriRelative;
        this.stringMediaTypeMap = stringMediaTypeMap;
        this.payload = payload;
        this.httpMethod = httpMethod;
        this.headers = headers;
    }

    public HttpRequest() { }

    public String getUriRelative() {
        return uriRelative;
    }

    public void setUriRelative(String uriRelative) {
        this.uriRelative = uriRelative;
    }

    public Map<String, MediaType> getStringMediaTypeMap() {
        return stringMediaTypeMap;
    }

    public void setStringMediaTypeMap(Map<String, MediaType> stringMediaTypeMap) {
        this.stringMediaTypeMap = stringMediaTypeMap;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }
}
