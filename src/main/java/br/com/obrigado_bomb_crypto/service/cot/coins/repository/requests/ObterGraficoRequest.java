package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.infraestructure.JsonHelper;
import org.springframework.http.HttpMethod;

import java.util.HashMap;

public class ObterGraficoRequest extends HttpRequest {
    public ObterGraficoRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://calm-caverns-51520.herokuapp.com/api/v1/grafico");
    }
}
