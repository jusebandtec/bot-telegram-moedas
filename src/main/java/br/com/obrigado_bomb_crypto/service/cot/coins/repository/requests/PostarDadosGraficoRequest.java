package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.infraestructure.JsonHelper;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.HashMap;

public class PostarDadosGraficoRequest extends HttpRequest {
    public PostarDadosGraficoRequest(PostarDataGraficoRequestData data) {
        setHttpMethod(HttpMethod.POST);
        setPayload(new JsonHelper<PostarDataGraficoRequestData>().serializeToJson(data));
        setUriRelative("https://calm-caverns-51520.herokuapp.com/api/v1/grafico");
        setStringMediaTypeMap(new HashMap<>()
        {{
            put("Content-Type", new MediaType(MediaType.APPLICATION_JSON));
        }});
    }
}
