package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import org.springframework.http.HttpMethod;

public class ObterHealthCheckApiRequest extends HttpRequest {
    public ObterHealthCheckApiRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://blooming-reaches-21421.herokuapp.com/v1/health-check");
    }
}
