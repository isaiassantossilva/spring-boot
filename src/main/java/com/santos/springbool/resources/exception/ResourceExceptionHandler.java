package com.santos.springbool.resources.exception;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.santos.springbool.services.exception.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Tratar possíveis erros nas requisições;
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        
        HttpStatus status = HttpStatus.NOT_FOUND;
        // String trace = Arrays.toString(e.getStackTrace());
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado", "", e.getMessage(), request.getRequestURI());
        
        return ResponseEntity.status(status).body(err);
    }
}
