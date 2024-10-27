package com.nv.busca_cep;

import com.nv.busca_cep.dto.EnderecoDto;
import com.nv.busca_cep.service.impl.EnderecoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource(properties = "spring.wiremock.url=http://localhost:8080/cep/")
public class EnderecoServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@Autowired
	private EnderecoServiceImpl enderecoService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testBuscarEndereco() {
		EnderecoDto enderecoSimulado = EnderecoDto.builder()
				.cep("12345678")
				.logradouro("Rua Exemplo")
				.bairro("Bairro Exemplo")
				.localidade("Cidade Exemplo")
				.uf("UF")
		.build();

		EnderecoDto resultadoDto = enderecoService.buscarCep("12345678");
		assertEquals("12345678", resultadoDto.getCep());
		assertEquals("Rua Exemplo", resultadoDto.getLogradouro());
		assertEquals("Bairro Exemplo", resultadoDto.getBairro());
		assertEquals("Cidade Exemplo", resultadoDto.getLocalidade());
		assertEquals("UF", resultadoDto.getUf());
	}

}
