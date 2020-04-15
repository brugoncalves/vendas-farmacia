package br.com.farmacia.services.exceptions;

public class ValidacaoDeEmailException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public ValidacaoDeEmailException(String msg) {
		 super(msg);
	}
}
