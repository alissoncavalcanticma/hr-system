package br.com.ctfera.user_api.resources.exceptions;

import br.com.ctfera.user_api.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice //Annotation para controle de exceções
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class) //Annotation para definir esse handler para tratamento de ObjectNotFound
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
          new StandardError(
                  LocalDateTime.now(),
                  ex.getMessage(),
                  HttpStatus.NOT_FOUND.value(),
                  request.getRequestURI())
        );
    }
}
