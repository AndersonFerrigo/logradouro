package com.nv.busca_cep.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDto {

	private int id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private LocalDateTime dataHoraRequisicao;

	public String formatarCep() {
		return cep.replaceAll("[^0-9]", "");
	}

}
