package br.com.obrigado_bomb_crypto.service.cot.coins.controllers;

import br.com.obrigado_bomb_crypto.service.cot.coins.domain.Coins;
import br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository.ObterValorMoedasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/v1/coins")
@RestController
public class CoinsController {

    private ObterValorMoedasRepository valueCoinsRepository;

    public CoinsController() throws Exception {
        this.valueCoinsRepository = new br.com.obrigado_bomb_crypto.service.cot.coins.repository.ObterValorMoedasRepository();
    }

    @GetMapping
    public ResponseEntity getAllCoins() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(
                new Coins(
                        this.valueCoinsRepository.getUSD(),
                        this.valueCoinsRepository.getEUR(),
                        this.valueCoinsRepository.getBCOIN(),
                        this.valueCoinsRepository.getBTC(),
                        this.valueCoinsRepository.getBRL(),
                        this.valueCoinsRepository.getBCOINinUSD(),
                        this.valueCoinsRepository.getEtherium(),
                        this.valueCoinsRepository.getShibaInu()
                )
        );
    }
}
