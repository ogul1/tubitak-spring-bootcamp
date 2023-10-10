package com.ogul.bootcamp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String ERROR_FORMAT = "Exception: %s, Error Code: %s, Error Message: %s";

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handle(RuntimeException exception) {
        log.error(String.format(ERROR_FORMAT, exception.getClass().getName(),
                                                HttpStatus.INTERNAL_SERVER_ERROR,
                                                exception.getMessage()), exception);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(CustomErrorFormat.builder()
                        .id(1L)
                        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(exception.getMessage())
                        .build());
    }
}
