package edu.cesed.tap.controller;

public class AlunoAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public AlunoAlreadyExistsException(final String message) {
		super(message);
	}

}
