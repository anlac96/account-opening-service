package com.github.anlac96.account.opening.service.service.exception;

public abstract class AbstractBusinessException extends RuntimeException {

    public AbstractBusinessException(String message) {
        super(message);
    }

    public AbstractBusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
