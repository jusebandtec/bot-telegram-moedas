package br.com.obrigado_bomb_crypto.service.cot.coins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ServiceCotCoinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCotCoinsApplication.class, args);
	}

}
