package br.com.obrigado_bomb_crypto.service.cot.coins.controllers;

import br.com.obrigado_bomb_crypto.service.cot.coins.domain.Coins;
import br.com.obrigado_bomb_crypto.service.cot.coins.domain.repository.ObterValorMoedasRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/coins")
@RestController
@AllArgsConstructor
public class CoinsController {

    public ObterValorMoedasRepository valueCoinsRepository;

    @GetMapping
    public ResponseEntity getAllCoins() throws Exception {
        this.valueCoinsRepository.getAllCoins();
        return ResponseEntity.status(HttpStatus.OK).body(
                new Coins(
                        this.valueCoinsRepository.getUSD(),
                        this.valueCoinsRepository.getEUR(),
                        this.valueCoinsRepository.getBcoinBrl(),
                        this.valueCoinsRepository.getBTC(),
                        this.valueCoinsRepository.getBRL(),
                        this.valueCoinsRepository.getBcoinUsd(),
                        this.valueCoinsRepository.getEtherium(),
                        valueCoinsRepository.getShibaInuBrl(),
                        valueCoinsRepository.getShibaInuUsd(),
                        valueCoinsRepository.getSpeBrl(),
                        valueCoinsRepository.getSpeUsd()
                )
        );
    }
}
