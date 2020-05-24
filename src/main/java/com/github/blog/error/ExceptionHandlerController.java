package com.github.blog.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

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
}
