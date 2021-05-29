package com.joubo.apisuperheroes.error;

import com.joubo.apisuperheroes.exception.SuperHeroeNoEncontrado;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({EmptyResultDataAccessException.class,
      InvalidDataAccessResourceUsageException.class})
  protected ResponseEntity<Object> handleEmptyResultDataAccess(
      final RuntimeException ex, final WebRequest request) {
    final String bodyOfResponse = "El recurso indicado no existe";
    return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND,
        request);
  }

  @ExceptionHandler({SuperHeroeNoEncontrado.class})
  protected ResponseEntity<Object> handleRecursoNoEncontrado(
      final RuntimeException ex, final WebRequest request) {
    return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND,
        request);
  }

}
