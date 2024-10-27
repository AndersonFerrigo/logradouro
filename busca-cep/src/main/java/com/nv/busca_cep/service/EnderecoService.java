package com.nv.busca_cep.service;

import com.nv.busca_cep.dto.EnderecoDto;

public interface EnderecoService {

	EnderecoDto buscarCep(String cep);

}
