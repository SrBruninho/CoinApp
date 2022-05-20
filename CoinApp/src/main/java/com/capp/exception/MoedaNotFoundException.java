package com.capp.exception;

public class MoedaNotFoundException extends RuntimeException {
	
	/**
	 * Classe que herda RuntimeException customizada para Moeda
	 */
	private static final long serialVersionUID = 1L;

	public MoedaNotFoundException( String msg ) {
		super( msg );
	}

}
