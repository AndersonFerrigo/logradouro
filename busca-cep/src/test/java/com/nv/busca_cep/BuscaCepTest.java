package com.nv.busca_cep;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.nv.busca_cep.dto.EnderecoDto;
import com.nv.busca_cep.facade.EnderecoFacade;
import com.nv.busca_cep.mapper.EnderecoMapper;
import com.nv.busca_cep.repository.EnderecoRepository;
import com.nv.busca_cep.service.EnderecoService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BuscaCepTest {


	@Mock
	private RestTemplate restTemplate;

	@BeforeEach
	public void setup() {
		restTemplate = new RestTemplate();
		WireMock.configureFor("localhost", 8080);
	}


	@Test
	void validateWireMock() throws JSONException {

		stubFor(get(urlPathMatching("/cep/(\\d{5}-\\d{3}|\\d{8})"))
				.willReturn(aResponse()
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody("{\"cep\": \"12345678\", \"logradouro\": \"Rua Exemplo\", \"bairro\": \"Bairro Exemplo\", \"localidade\": \"Cidade Exemplo\", \"uf\": \"UF\"}")));

		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/cep/12345678", String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		JSONObject jsonObject = new JSONObject(response.getBody());

		assertNotNull(jsonObject);
		assertEquals(jsonObject.get("cep"), "12345678");
		assertEquals(jsonObject.get("logradouro"), "Rua Exemplo");
		assertEquals(jsonObject.get("bairro"), "Bairro Exemplo");
		assertEquals(jsonObject.get("localidade"), "Cidade Exemplo");
		assertEquals(jsonObject.get("uf"), "UF");

	}

}
