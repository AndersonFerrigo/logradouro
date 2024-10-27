package com.nv.busca_cep.config;

import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseDefinitionTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.ResponseDefinition;

public class CepResponseTransformer extends ResponseDefinitionTransformer {

	@Override
	public String getName() {
		return "cep-response-transformer";
	}

	@Override
	public ResponseDefinition transform(Request request, ResponseDefinition responseDefinition, FileSource fileSource, Parameters parameters) {
		String cep = request.getUrl().split("/")[2];

		String jsonResponse = generateDynamicResponse(cep);
		return ResponseDefinition.okForJson(jsonResponse);
	}

	private String generateDynamicResponse(String cep) {
		return "{ \"cep\": \"" + cep + "\", \"logradouro\": \"Rua Exemplo\", \"bairro\": \"Bairro Exemplo\", \"localidade\": \"Cidade Exemplo\", \"uf\": \"UF\" }";
	}

}
