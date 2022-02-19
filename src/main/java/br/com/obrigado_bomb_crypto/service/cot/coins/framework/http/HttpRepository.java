package br.com.obrigado_bomb_crypto.service.cot.coins.framework.http;

public class HttpRepository {

    private HttpConnection httpConnection;

    public HttpRepository() {
        this.httpConnection = new HttpConnection();
    }

    public HttpResponse doRequest(HttpRequest httpRequest) throws Exception {
        return this.httpConnection.doRequest(httpRequest);
    }

    public HttpConnection getHttpConnection() {
        return httpConnection;
    }

    public void setHttpConnection(HttpConnection httpConnection) {
        this.httpConnection = httpConnection;
    }
}
