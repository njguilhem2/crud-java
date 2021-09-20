package com.crud.java.entrypoint.handler.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException extends RuntimeException {
    public GlobalException(String message) {
        super(message);
    }
}
