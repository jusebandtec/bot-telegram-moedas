package br.com.obrigado_bomb_crypto.service.cot.coins.services;


import org.apache.maven.surefire.shared.io.FileUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ServiceImage implements br.com.obrigado_bomb_crypto.service.cot.coins.domain.services.ServiceImage {

    @Override
    public void saveImgBase64(String base64) throws IOException {
        byte[] decodedBytes = Base64.getDecoder().decode(base64);
        FileUtils.writeByteArrayToFile(new File("grafico.png"), decodedBytes);
    }
}
