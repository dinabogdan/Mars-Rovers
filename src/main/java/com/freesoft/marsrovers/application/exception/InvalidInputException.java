package com.freesoft.marsrovers.application.exception;

public class InvalidInputException extends RuntimeException {

    private String message;
    private Throwable cause;

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
        this.cause = cause;
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
