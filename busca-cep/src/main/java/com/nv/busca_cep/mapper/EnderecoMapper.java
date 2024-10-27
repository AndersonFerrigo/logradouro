package com.nv.busca_cep.mapper;

import com.nv.busca_cep.domain.Endereco;
import com.nv.busca_cep.dto.EnderecoDto;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

	public Endereco toEntity(EnderecoDto enderecoDto){
		return Endereco.builder()
				.cep(enderecoDto.formatarCep())
				.logradouro(enderecoDto.getLogradouro())
				.bairro(enderecoDto.getBairro())
				.localidade(enderecoDto.getLocalidade())
				.uf(enderecoDto.getUf())
				.dataHoraRequisicao(enderecoDto.getDataHoraRequisicao())
				.build();

	}

	public EnderecoDto toDto(Endereco endereco){
		return EnderecoDto.builder()
				.id(endereco.getId())
				.cep(endereco.formatarCepComPonto())
				.logradouro(endereco.getLogradouro())
				.bairro(endereco.getBairro())
				.localidade(endereco.getLocalidade())
				.uf(endereco.getUf())
				.dataHoraRequisicao(endereco.getDataHoraRequisicao())
				.build();
	}

}
