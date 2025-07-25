package io.github.tavodin.ecommerce.controllers.handler;

import io.github.tavodin.ecommerce.dto.ResponseErrorDTO;
import io.github.tavodin.ecommerce.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> handleResourceNotFound(HttpServletRequest request, ResourceNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ResponseErrorDTO error = new ResponseErrorDTO();

        error.setTimestamp(LocalDateTime.now());
        error.setError(status.name());
        error.setMessage(ex.getMessage());
        error.setStatus(status.value());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
