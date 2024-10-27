package com.nv.busca_cep.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class EnderecoUtilsTest {

	@Test
	void mustReturnTrueCepOKWithNoHifen(){
		assertTrue(!EnderecoUtils.validaCep("12345678"));
	}

	@Test
	void mustReturnTrueCepOKWithHifen(){
		assertTrue(!EnderecoUtils.validaCep("12345-678"));
	}

	@Test
	void mustReturnFalseCepMaiorQue8(){
		assertFalse(!EnderecoUtils.validaCep("1234567822"));
	}

	@Test
	void mustReturnFalseCepMenorQue8(){
		assertFalse(!EnderecoUtils.validaCep("67822"));
	}

}
