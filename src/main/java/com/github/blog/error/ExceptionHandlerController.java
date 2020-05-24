package com.github.blog.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static java.util.Objects.isNull;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(isNull(ex.getMessage()) ? "Not found" : ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, NOT_FOUND);
    }
}
