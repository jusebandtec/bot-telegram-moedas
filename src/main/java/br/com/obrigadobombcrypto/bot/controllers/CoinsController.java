package br.com.obrigadobombcrypto.bot.controllers;

import br.com.obrigadobombcrypto.bot.domain.Coins;
import br.com.obrigadobombcrypto.bot.domain.repository.ValueCoinsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/v1/coins")
@RestController
public class CoinsController {

    private ValueCoinsRepository valueCoinsRepository;

    public CoinsController() throws IOException {
        this.valueCoinsRepository = new br.com.obrigadobombcrypto.bot.repository.ValueCoinsRepository();
    }

    @GetMapping
    public ResponseEntity getAllCoins() throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(
                new Coins(
                        this.valueCoinsRepository.getUSD(), this.valueCoinsRepository.getEUR(), this.valueCoinsRepository.getBCOIN(), this.valueCoinsRepository.getBTC(), this.valueCoinsRepository.getBRL()
                )
        );
    }
}
