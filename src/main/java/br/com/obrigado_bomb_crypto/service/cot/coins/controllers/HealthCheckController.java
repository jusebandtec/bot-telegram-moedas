package br.com.obrigado_bomb_crypto.service.cot.coins.controllers;

import br.com.obrigado_bomb_crypto.service.cot.coins.controllers.dto.HealthCheckDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1/health-check")
@RestController
public class HealthCheckController {

    @GetMapping
    public ResponseEntity getStatus() {
        return ResponseEntity.status(HttpStatus.OK).body(new HealthCheckDto());
    }
}
