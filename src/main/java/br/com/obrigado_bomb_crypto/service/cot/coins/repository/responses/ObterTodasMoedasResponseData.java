package br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ObterTodasMoedasResponseData {

    private String result;
    private String base_code;
    private CoinsResponseData conversion_rates;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public CoinsResponseData getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(CoinsResponseData conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
