package br.com.obrigado_bomb_crypto.service.cot.coins.domain.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

public interface ServiceImage {
    void saveImgBase64(String base64) throws IOException;
}
