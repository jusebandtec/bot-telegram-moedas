package br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository;

import br.com.obrigado_bomb_crypto.service.cot.coins.repository.responses.GraficoResponseData;
import org.springframework.stereotype.Service;

public interface ObterGraficoRepository {
    GraficoResponseData obterDadosGrafico() throws Exception;
    void postarDadosGrafico(double valorMoeda) throws Exception;
}
