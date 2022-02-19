package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import org.springframework.http.HttpMethod;

import java.util.HashMap;

public class ObterPrincipaisMoedasRequest extends HttpRequest {
    public ObterPrincipaisMoedasRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://v6.exchangerate-api.com/v6/e3584d13af8f66d3fdbfb196/latest/BRL");
    }
}
