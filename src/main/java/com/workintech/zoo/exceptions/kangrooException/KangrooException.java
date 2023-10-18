package com.workintech.zoo.exceptions.kangrooException;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class KangrooException extends RuntimeException {
    private HttpStatus status;

    public KangrooException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
