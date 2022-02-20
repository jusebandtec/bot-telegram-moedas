package br.com.obrigado_bomb_crypto.service.cot.coins.repository;

import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpConnection;
import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRepository;
import br.com.obrigado_bomb_crypto.service.cot.coins.framework.http.HttpRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.infraestructure.JsonHelper;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.ObterGraficoRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.PostarDadosGraficoRequest;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.requests.PostarDataGraficoRequestData;
import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.GraficoResponseData;
import org.springframework.stereotype.Service;

@Service
public class ObterGraficoRepository extends HttpRepository implements br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository.ObterGraficoRepository {

    @Override
    public GraficoResponseData obterDadosGrafico() throws Exception {
        var obterGraficoRequest = new ObterGraficoRequest();
        var response = this.getHttpConnection().doRequest(obterGraficoRequest);
        return new JsonHelper<GraficoResponseData>().deserializeFromString(response.getContentResponse(), GraficoResponseData.class);
    }

    @Override
    public void postarDadosGrafico(double valorMoeda) throws Exception {
        var postarDados = new PostarDadosGraficoRequest(new PostarDataGraficoRequestData(valorMoeda));
        this.getHttpConnection().doRequest(postarDados);
    }
}
