package com.nv.busca_cep.mapper;

import com.nv.busca_cep.domain.Endereco;
import com.nv.busca_cep.dto.EnderecoDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class ValidateMapperTest {

	@InjectMocks
	private EnderecoMapper enderecoMapper;

	@Test
	void validateMApperToEntity(){

		EnderecoDto enderecoDto = EnderecoDto.builder()
				.cep("12345678")
				.logradouro("Rua Exemplo")
				.bairro("Bairro Exemplo")
				.localidade("Cidade Exemplo")
				.uf("UF")
				.dataHoraRequisicao(LocalDateTime.now())
				.build();

		Endereco endereco = enderecoMapper.toEntity(enderecoDto);

		assertEquals(endereco.getCep(), enderecoDto.getCep());
		assertEquals(endereco.getBairro(), enderecoDto.getBairro());
		assertEquals(endereco.getLocalidade(), enderecoDto.getLocalidade());
		assertEquals(endereco.getUf(), enderecoDto.getUf());

	}

	@Test
	void validateMapperToDto(){
		Endereco endereco =	Endereco.builder()
				.cep("12345678")
				.logradouro("Rua Exemplo")
				.bairro("Bairro Exemplo")
				.localidade("Cidade Exemplo")
				.uf("UF")
				.dataHoraRequisicao(LocalDateTime.now())
				.build();

		EnderecoDto enderecoDto = enderecoMapper.toDto(endereco);

		assertNotEquals(enderecoDto.getCep(), endereco.getCep());
		assertEquals(enderecoDto.getBairro(), endereco.getBairro());
		assertEquals(enderecoDto.getLocalidade(), endereco.getLocalidade());
		assertEquals(enderecoDto.getUf(), endereco.getUf());

	}

}
