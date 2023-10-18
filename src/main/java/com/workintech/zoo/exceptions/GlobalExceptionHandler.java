package com.workintech.zoo.exceptions;

import com.workintech.zoo.exceptions.kangrooException.KangrooErrorResponse;
import com.workintech.zoo.exceptions.kangrooException.KangrooException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<KangrooErrorResponse> handleException(KangrooException kangrooException) {
        KangrooErrorResponse response = new KangrooErrorResponse(
                kangrooException.getStatus().value(), kangrooException.getMessage(), System.currentTimeMillis()
        );
        log.error(kangrooException.getMessage());
        return new ResponseEntity<>(response, kangrooException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<KangrooErrorResponse> handleException(Exception exception) {
        KangrooErrorResponse response = new KangrooErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis()
        );
        log.error(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
