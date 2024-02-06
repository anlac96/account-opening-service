package com.github.anlac96.account.opening.service.service.exception;

public class DossierNotFoundException extends AbstractBusinessException {

    public DossierNotFoundException() {
        super();
    }

    public DossierNotFoundException(String message) {
        super(message);
    }

    public DossierNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
