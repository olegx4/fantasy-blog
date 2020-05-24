package com.github.blog.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(defaultIfEmpty(ex.getMessage(), "Not found"));
        return new ResponseEntity<>(errorResponseDto, NOT_FOUND);
    }

    @ExceptionHandler(value = {ConflictException.class})
    protected ResponseEntity<ErrorResponseDto> handleConflictException(ConflictException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(defaultIfEmpty(ex.getMessage(), "Conflict"));
        return new ResponseEntity<>(errorResponseDto, CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, String> body = new LinkedHashMap<>();
        ex.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    if (error instanceof FieldError) {
                        body.put(((FieldError) error).getField(), error.getDefaultMessage());
                    } else {
                        body.put(error.getObjectName(), error.getDefaultMessage());
                    }
                });
        return new ResponseEntity<>(body, UNPROCESSABLE_ENTITY);
    }
}
