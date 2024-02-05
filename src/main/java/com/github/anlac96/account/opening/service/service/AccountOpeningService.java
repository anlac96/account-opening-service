package com.github.anlac96.account.opening.service.service;

import com.github.anlac96.account.opening.service.model.IdentityDocument;
import com.github.anlac96.account.opening.service.model.OpeningDossier;
import com.github.anlac96.account.opening.service.model.customer.Customer;
import com.github.anlac96.account.opening.service.service.exception.AbstractBusinessException;

public interface AccountOpeningService {
    OpeningDossier createNewDossier() throws AbstractBusinessException;

    OpeningDossier getDossierById(String dossierId) throws AbstractBusinessException;

    OpeningDossier updateIdentityDocument(String dossierId, IdentityDocument identityDocument) throws AbstractBusinessException;

    OpeningDossier updateCustomerInformation(String dossierId, Customer customer) throws AbstractBusinessException;
}
