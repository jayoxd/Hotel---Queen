package com.registro.usuarios.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.registro.usuarios.excepciones.ReservaExistenteException;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@ControllerAdvice
public class ReservaExistenteExceptionHandler {

    @ExceptionHandler(ReservaExistenteException.class)
    public ResponseEntity<ErrorResponse> handleReservaExistenteException(ReservaExistenteException ex) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse("Ya existe una reserva para el rango de fechas dado"), HttpStatus.BAD_REQUEST);
    }

}