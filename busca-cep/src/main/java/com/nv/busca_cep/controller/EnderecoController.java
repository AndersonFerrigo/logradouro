package com.nv.busca_cep.controller;

import com.nv.busca_cep.dto.EnderecoDto;
import com.nv.busca_cep.facade.EnderecoFacade;
import com.nv.busca_cep.utils.EnderecoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EnderecoController {

	private final EnderecoFacade enderecoFacade;

	@GetMapping("/api/endereco/{cep}")
	public ResponseEntity<EnderecoDto> buscarCep(@PathVariable String cep){

		if (EnderecoUtils.validaCep(cep)){
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		EnderecoDto enderecoDto = enderecoFacade.buscarCep(cep);
		return new ResponseEntity<>(enderecoDto, HttpStatus.CREATED);
	}
}

