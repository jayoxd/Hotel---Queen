package com.registro.usuarios.excepciones;

public class ReservaExistenteException extends RuntimeException {
    public ReservaExistenteException(String message) {
        super(message);
    }
}