package net.weg.gestaotransporteapi.controller;

import net.weg.gestaotransporteapi.model.dto.response.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ExceptionResponseDTO> exceptionHandler(Exception e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("Erro encontrado!", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
