package com.github.anlac96.account.opening.service.service;

import com.github.anlac96.account.opening.service.model.BankRegistration;

public interface BankRegistrationRepository {
    BankRegistration create(BankRegistration dossier);

    BankRegistration findById(String dossierId);

    BankRegistration update(BankRegistration dossier);

    BankRegistration delete(BankRegistration dossier);
}
