package com.github.anlac96.account.opening.service.service;

import com.github.anlac96.account.opening.service.model.IdentityDocument;
import com.github.anlac96.account.opening.service.model.BankRegistration;
import com.github.anlac96.account.opening.service.model.customer.Customer;
import com.github.anlac96.account.opening.service.service.exception.AbstractBusinessException;

public interface BankRegistrationService {
    BankRegistration createNewDossier() throws AbstractBusinessException;

    BankRegistration getDossierById(String dossierId) throws AbstractBusinessException;

    BankRegistration updateIdentityDocument(String dossierId, IdentityDocument identityDocument) throws AbstractBusinessException;

    BankRegistration updateCustomerInformation(String dossierId, Customer customer) throws AbstractBusinessException;
}
