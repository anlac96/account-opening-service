package com.github.anlac96.account.opening.service.implementation;

import com.github.anlac96.account.opening.service.model.BankRegistration;
import com.github.anlac96.account.opening.service.model.IdentityDocument;
import com.github.anlac96.account.opening.service.model.customer.Address;
import com.github.anlac96.account.opening.service.model.customer.Customer;
import com.github.anlac96.account.opening.service.service.BankRegistrationService;
import com.github.anlac96.account.opening.service.service.BankRegistrationRepository;
import com.github.anlac96.account.opening.service.service.exception.AbstractBusinessException;
import com.github.anlac96.account.opening.service.service.exception.BankRegistrationNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

@ApplicationScoped
public class BankRegistrationServiceImpl implements BankRegistrationService {

    private BankRegistrationRepository registrationRepository;

    @Inject
    public BankRegistrationServiceImpl(BankRegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public BankRegistration createNewRegistration() throws AbstractBusinessException {
        BankRegistration registration = new BankRegistration();
        registration.setRegistrationId(UUID.randomUUID().toString());
        Customer customer = new Customer();
        customer.setAddress(new Address());
        registration.setCustomer(customer);
        registration.setIdentityDocument(new IdentityDocument());
        registration.setProductAccounts(new ArrayList<>());
        return registrationRepository.create(registration);
    }

    @Override
    public BankRegistration getRegistrationById(String registrationId) throws AbstractBusinessException {
        BankRegistration registration = registrationRepository.findById(registrationId);
        if (registration == null) {
            throw new BankRegistrationNotFoundException();
        }
        return registration;
    }

    @Override
    public BankRegistration updateIdentityDocument(String registrationId, IdentityDocument identityDocument) throws AbstractBusinessException {
        BankRegistration registration = registrationRepository.findById(registrationId);
        if (registration == null) {
            throw new BankRegistrationNotFoundException();
        }

        updateIdentityDocumentIntoRegistration(identityDocument, registration);
        registrationRepository.update(registration);
        return registration;
    }

    private static void updateIdentityDocumentIntoRegistration(IdentityDocument identityDocument, BankRegistration registration) {
        IdentityDocument registrationIdentityDocument = registration.getIdentityDocument();
        mapDataIfNotNull(identityDocument::getDocumentType, registrationIdentityDocument::setDocumentType);
        mapDataIfNotNull(identityDocument::getNumber, registrationIdentityDocument::setNumber);
        mapDataIfNotNull(identityDocument::getValidFrom, registrationIdentityDocument::setValidFrom);
        mapDataIfNotNull(identityDocument::getValidTill, registrationIdentityDocument::setValidTill);
    }

    public static <T> void mapDataIfNotNull(Supplier<T> supplier, Consumer<T> setterMethod) {
        T suppliedValue = supplier.get();
        if (suppliedValue != null) {
            setterMethod.accept(suppliedValue);
        }
    }

    @Override
    public BankRegistration updateCustomerInformation(String registrationId, Customer customer) throws AbstractBusinessException {
        BankRegistration registration = registrationRepository.findById(registrationId);
        if (registration == null) {
            throw new BankRegistrationNotFoundException();
        }

        mapCustomerIntoRegistration(customer, registration);
        registrationRepository.update(registration);
        return registration;
    }

    private static void mapCustomerIntoRegistration(Customer customer, BankRegistration registration) {
        Customer registrationCustomer = registration.getCustomer();
        mapDataIfNotNull(customer::getFirstName, registrationCustomer::setFirstName);
        mapDataIfNotNull(customer::getLastName, registrationCustomer::setLastName);
        mapDataIfNotNull(customer::getBirthDate, registrationCustomer::setBirthDate);
        mapDataIfNotNull(customer::getNationality, registrationCustomer::setNationality);

        Address registrationCustomerAddress = registrationCustomer.getAddress();
        Address inputAddress = customer.getAddress();
        mapDataIfNotNull(inputAddress::getCountry, registrationCustomerAddress::setCountry);
        mapDataIfNotNull(inputAddress::getZipCode, registrationCustomerAddress::setZipCode);
        mapDataIfNotNull(inputAddress::getCity, registrationCustomerAddress::setCity);
        mapDataIfNotNull(inputAddress::getStreet, registrationCustomerAddress::setStreet);
        mapDataIfNotNull(inputAddress::getHouseNumber, registrationCustomerAddress::setHouseNumber);
    }
}
