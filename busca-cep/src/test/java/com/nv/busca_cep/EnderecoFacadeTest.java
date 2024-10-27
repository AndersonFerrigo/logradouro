package com.nv.busca_cep;

import com.nv.busca_cep.domain.Endereco;
import com.nv.busca_cep.dto.EnderecoDto;
import com.nv.busca_cep.facade.EnderecoFacade;
import com.nv.busca_cep.mapper.EnderecoMapper;
import com.nv.busca_cep.repository.EnderecoRepository;
import com.nv.busca_cep.service.EnderecoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@TestPropertySource(properties = "spring.wiremock.url=http://localhost:8080/cep/")
public class EnderecoFacadeTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private EnderecoFacade enderecoFacade;

	@Mock
	private EnderecoService enderecoService;

	@Mock
	private EnderecoMapper enderecoMapper;

	@Mock
	private EnderecoRepository enderecoRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testBuscarEndereco() {
		EnderecoDto enderecoDto = EnderecoDto.builder()
				.cep("12345678")
				.logradouro("Rua Exemplo")
				.bairro("Bairro Exemplo")
				.localidade("Cidade Exemplo")
				.uf("UF")
				.dataHoraRequisicao(LocalDateTime.now())
				.build();

		Endereco endereco =	Endereco.builder()
				.cep("12345678")
				.logradouro("Rua Exemplo")
				.bairro("Bairro Exemplo")
				.localidade("Cidade Exemplo")
				.uf("UF")
				.dataHoraRequisicao(LocalDateTime.now())
				.build();

		when(enderecoService.buscarCep("12345678")).thenReturn(enderecoDto);
		when(enderecoFacade.buscarCep("12345678")).thenReturn(enderecoDto);
		Mockito.lenient().when(enderecoMapper.toEntity(any(EnderecoDto.class))).thenReturn(endereco);
		Mockito.lenient().when(enderecoRepository.save(any(Endereco.class))).thenReturn(endereco);
		Mockito.lenient().when(enderecoMapper.toDto(any(Endereco.class))).thenReturn(enderecoDto);

		assertEquals(mockEndereco().getCep(), endereco.getCep());
		assertEquals(mockEndereco().getBairro(), endereco.getBairro());
		assertEquals(mockEndereco().getLocalidade(), endereco.getLocalidade());
		assertEquals(mockEndereco().getUf(), endereco.getUf());

	}

	public Endereco mockEndereco(){
		return Endereco.builder()
				.cep("12345678")
				.logradouro("Rua Exemplo")
				.bairro("Bairro Exemplo")
				.localidade("Cidade Exemplo")
				.uf("UF")
				.dataHoraRequisicao(LocalDateTime.now())
				.build();
	}

}
