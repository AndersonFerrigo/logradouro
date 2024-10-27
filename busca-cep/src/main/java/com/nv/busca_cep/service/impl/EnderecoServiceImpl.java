package com.nv.busca_cep.service.impl;

import com.nv.busca_cep.dto.EnderecoDto;
import com.nv.busca_cep.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

	private final RestTemplate restTemplate;

	@Value("${spring.wiremock.url}")
	private String wiremockUrl;

	@Override
	public EnderecoDto buscarCep(String cep) {
		try {
			return restTemplate.getForObject(wiremockUrl.concat(cep), EnderecoDto.class);
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar CEP: " + e.getMessage(), e);
		}
	}
}
