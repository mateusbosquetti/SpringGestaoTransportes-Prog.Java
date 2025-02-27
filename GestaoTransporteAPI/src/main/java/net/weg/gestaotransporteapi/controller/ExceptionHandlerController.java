package net.weg.gestaotransporteapi.controller;

import jakarta.xml.bind.ValidationException;
import net.weg.gestaotransporteapi.model.dto.response.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(exception = Exception.class)
    public ResponseEntity<ExceptionResponseDTO> ExceptionHandler (Exception e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("Exception!", e.getClass() , e.getMessage(), Instant.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> MethodArgumentNotValidExceptionHandler (MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("Falha na Validação!", e.getClass(), e.getMessage(), Instant.now()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(exception = NoSuchElementException.class)
    public ResponseEntity<ExceptionResponseDTO> NoSuchElementExceptionHandler (NoSuchElementException e) {
        return new ResponseEntity<>(new ExceptionResponseDTO("Elemento não Encotrado!", e.getClass(), e.getMessage(), Instant.now()), HttpStatus.BAD_REQUEST);
    }

}
