package domain.responses;

public class GetAllCoinsResponse {

    private String result;
    private String base_code;
    private CoinsResponse conversion_rates;

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

    public CoinsResponse getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(CoinsResponse conversion_rates) {
        this.conversion_rates = conversion_rates;
    }
}
