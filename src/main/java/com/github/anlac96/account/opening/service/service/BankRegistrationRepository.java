package com.github.anlac96.account.opening.service.service;

import com.github.anlac96.account.opening.service.model.BankRegistration;

public interface BankRegistrationRepository {
    BankRegistration create(BankRegistration registration);

    BankRegistration findById(String registrationId);

    BankRegistration update(BankRegistration registration);

    BankRegistration delete(BankRegistration registration);
}
