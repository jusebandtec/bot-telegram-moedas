package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import org.springframework.http.HttpMethod;

public class ObterHealthCheckApiGraficoRequest extends HttpRequest {
    public ObterHealthCheckApiGraficoRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://calm-caverns-51520.herokuapp.com/health-check");
    }
}
