package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.HashMap;

public class ObterHealthCheckApiRequest extends HttpRequest {
    public ObterHealthCheckApiRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://lit-harbor-97954.herokuapp.com/v1/health-check");
        setStringMediaTypeMap(new HashMap<>()
        {{
            put("Content-Type", new MediaType(MediaType.APPLICATION_JSON));
        }});
    }
}
