package br.com.obrigado_bomb_crypto.service.cot.coins.repository;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpConnection;
import br.com.obrigado_bomb_crypto.service.cot.coins.infraestructure.JsonHelper;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.ObterGraficoRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.PostarDadosGraficoRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.PostarDataGraficoRequestData;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.GraficoResponseData;

public class ObterGraficoRepository implements br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository.ObterGraficoRepository {

    private HttpConnection httpConnection;

    public ObterGraficoRepository() {
        this.httpConnection = new HttpConnection();
    }

    @Override
    public GraficoResponseData obterDadosGrafico() throws Exception {
        var obterGraficoRequest = new ObterGraficoRequest();
        var response = this.httpConnection.doRequest(obterGraficoRequest);
        return new JsonHelper<GraficoResponseData>().deserializeFromString(response.getContentResponse(), GraficoResponseData.class);
    }

    @Override
    public void postarDadosGrafico(double valorMoeda) throws Exception {
        var postarDados = new PostarDadosGraficoRequest(new PostarDataGraficoRequestData(valorMoeda));
        this.httpConnection.doRequest(postarDados);
    }
}
