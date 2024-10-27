package com.nv.busca_cep.utils;

public class EnderecoUtils {
	public static boolean validaCep(String cep){
		return !cep.matches("\\d{5}-?\\d{3}|\\d{8}");
	}

}
