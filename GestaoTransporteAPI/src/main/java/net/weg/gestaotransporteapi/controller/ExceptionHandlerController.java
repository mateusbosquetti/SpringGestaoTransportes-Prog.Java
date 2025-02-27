package net.weg.gestaotransporteapi.controller;

import net.weg.gestaotransporteapi.model.dto.response.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ExceptionResponseDTO> exceptionHandler(Exception e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("Erro encontrado!", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = NoSuchElementException.class)
    public ResponseEntity<ExceptionResponseDTO> exceptionHandler(NoSuchElementException e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("Não Encotrado!", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
