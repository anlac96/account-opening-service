package com.github.anlac96.account.opening.service.service.exception;

public class BankRegistrationNotFoundException extends AbstractBusinessException {

    public BankRegistrationNotFoundException() {
        super();
    }

    public BankRegistrationNotFoundException(String message) {
        super(message);
    }

    public BankRegistrationNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
