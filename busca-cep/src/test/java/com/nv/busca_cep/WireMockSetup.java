package com.nv.busca_cep;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.web.client.RestTemplate;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class WireMockSetup {

	private static WireMockServer wireMockServer;
	private RestTemplate restTemplate;
	@BeforeAll
	public static void setup() {

		wireMockServer = new WireMockServer(8080);
		wireMockServer.start();
		setupMappings(wireMockServer);

	}

	private static void setupMappings(WireMockServer wireMockServer) {
		wireMockServer.stubFor(get(urlPathMatching("/cep/(.*)"))
				.willReturn(aResponse()
						.withTransformers("response-template")
						.withStatus(200)
						.withHeader("Content-Type", "application/json")
						.withBody("{ \"cep\": \"{{request.pathSegments[2]}}\", \"logradouro\": \"Rua Exemplo\", \"bairro\": \"Bairro Exemplo\", \"localidade\": \"Cidade Exemplo\", \"uf\": \"UF\" }")));
	}

	@AfterAll
	public static void teardown() {
		wireMockServer.stop();
	}

}
