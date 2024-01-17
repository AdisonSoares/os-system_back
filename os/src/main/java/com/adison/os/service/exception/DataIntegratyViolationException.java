package com.adison.os.service.exception;

public class DataIntegratyViolationException extends RuntimeException{
    public DataIntegratyViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegratyViolationException(String message) {
        super(message);
    }
}