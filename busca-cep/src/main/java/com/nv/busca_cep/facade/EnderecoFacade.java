package com.nv.busca_cep.facade;

import com.nv.busca_cep.domain.Endereco;
import com.nv.busca_cep.dto.EnderecoDto;
import com.nv.busca_cep.mapper.EnderecoMapper;
import com.nv.busca_cep.repository.EnderecoRepository;
import com.nv.busca_cep.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EnderecoFacade {

	@Autowired
	private EnderecoMapper enderecoMapper;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EnderecoService enderecoService;

	public EnderecoDto buscarCep(String cep){
		EnderecoDto enderecoDto = enderecoService.buscarCep(cep);
		setDateTimeBeforeInsert(enderecoDto);
		Endereco endereco = enderecoMapper.toEntity(enderecoDto);
		Endereco savedEndereco = enderecoRepository.save(endereco);
		return enderecoMapper.toDto(savedEndereco);
	}

	private void setDateTimeBeforeInsert(EnderecoDto enderecoDto){
		enderecoDto.setDataHoraRequisicao(LocalDateTime.now());
	}

}
