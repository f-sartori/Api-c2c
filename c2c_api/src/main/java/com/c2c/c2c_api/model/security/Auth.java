package com.c2c.c2c_api.model.security;

import javax.xml.bind.DatatypeConverter;

import com.c2c.c2c_api.model.Usuario;



public class Auth {
	
	private static final String PREFIXO="*C2c|";
	public static String generateToken(Usuario usuario) {
		String token = PREFIXO+usuario.toString();
		token = DatatypeConverter.printHexBinary(token.getBytes());
		return token;
	}
	public static boolean isValid(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String credencial = new String(vetor);
		if(credencial.startsWith(PREFIXO)) {
			return true;
		}
		return false;
	}

}
