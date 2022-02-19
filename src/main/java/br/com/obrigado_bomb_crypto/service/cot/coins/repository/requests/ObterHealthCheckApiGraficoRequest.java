package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.HashMap;

public class ObterHealthCheckApiGraficoRequest extends HttpRequest {
    public ObterHealthCheckApiGraficoRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://calm-caverns-51520.herokuapp.com/health-check");
        setStringMediaTypeMap(new HashMap<>()
        {{
            put("Content-Type", new MediaType(MediaType.APPLICATION_JSON));
        }});
    }
}
