package com.sips.exceptions;

public class RecursoNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoNoEncontradoException(String message) {
        super(message);
    }

    public RecursoNoEncontradoException(Long id, String entity) {
        super(entity +" id "+ id +" no encontrado, vuelva a intentarlo.");
    }

}
