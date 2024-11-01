package com.nv.busca_cep.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class AppConfig {

	@Bean
	public RestTemplate enderecoRestTemplate(){
		return new RestTemplateBuilder()
				.setConnectTimeout(Duration.ofSeconds(15))
				.setReadTimeout(Duration.ofSeconds(15))
				.build();
	}
}
