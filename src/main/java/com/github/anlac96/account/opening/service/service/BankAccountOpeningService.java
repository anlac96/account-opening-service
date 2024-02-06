package com.github.anlac96.account.opening.service.service;

import com.github.anlac96.account.opening.service.model.IdentityDocument;
import com.github.anlac96.account.opening.service.model.BankAccountDossier;
import com.github.anlac96.account.opening.service.model.customer.Customer;
import com.github.anlac96.account.opening.service.service.exception.AbstractBusinessException;

public interface BankAccountOpeningService {
    BankAccountDossier createNewDossier() throws AbstractBusinessException;

    BankAccountDossier getDossierById(String dossierId) throws AbstractBusinessException;

    BankAccountDossier updateIdentityDocument(String dossierId, IdentityDocument identityDocument) throws AbstractBusinessException;

    BankAccountDossier updateCustomerInformation(String dossierId, Customer customer) throws AbstractBusinessException;
}
