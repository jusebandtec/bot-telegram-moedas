package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import org.springframework.http.HttpMethod;

import java.util.HashMap;

public class ObterShinaInuUsdRequest extends HttpRequest {
    public ObterShinaInuUsdRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://pro-api.coinmarketcap.com/v1/cryptocurrency/quotes/latest?id=5994&convert=USD");
        setHeaders(new HashMap(){{
            put("X-CMC_PRO_API_KEY","d9c76d00-264a-4dbd-ad00-063e29d618ef");
        }});
    }
}
