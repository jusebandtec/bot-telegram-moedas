package br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.util.HashMap;

public class ObterPrincipaisMoedasRequest extends HttpRequest {
    public ObterPrincipaisMoedasRequest() {
        setHttpMethod(HttpMethod.GET);
        setUriRelative("https://v6.exchangerate-api.com/v6/7ed504c6a909a940b6c17a25/latest/BRL");
    }
}
