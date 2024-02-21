package com.github.anlac96.account.opening.service.service;

import com.github.anlac96.account.opening.service.model.IdentityDocument;
import com.github.anlac96.account.opening.service.model.BankRegistration;
import com.github.anlac96.account.opening.service.model.customer.Customer;
import com.github.anlac96.account.opening.service.service.exception.AbstractBusinessException;

public interface BankRegistrationService {
    BankRegistration createNewRegistration() throws AbstractBusinessException;

    BankRegistration getRegistrationById(String registrationId) throws AbstractBusinessException;

    BankRegistration updateIdentityDocument(String registrationId, IdentityDocument identityDocument) throws AbstractBusinessException;

    BankRegistration updateCustomerInformation(String registrationId, Customer customer) throws AbstractBusinessException;
}
