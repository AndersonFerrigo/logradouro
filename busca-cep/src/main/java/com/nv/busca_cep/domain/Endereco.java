package com.nv.busca_cep.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@Table
public class Endereco {

	@Id
	@GeneratedValue
	private int id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	@Column(name = "data_hora_requisicao")
	private LocalDateTime dataHoraRequisicao;

	public String formatarCepComPonto() {
		return cep.substring(0, 5) + "-" + cep.substring(5);
	}

}
