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

    private BankRegistrationRepository dossierRepository;

    @Inject
    public BankRegistrationServiceImpl(BankRegistrationRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }

    @Override
    public BankRegistration createNewDossier() throws AbstractBusinessException {
        BankRegistration dossier = new BankRegistration();
        dossier.setDossierId(UUID.randomUUID().toString());
        Customer customer = new Customer();
        customer.setAddress(new Address());
        dossier.setCustomer(customer);
        dossier.setIdentityDocument(new IdentityDocument());
        dossier.setProductAccounts(new ArrayList<>());
        return dossierRepository.create(dossier);
    }

    @Override
    public BankRegistration getDossierById(String dossierId) throws AbstractBusinessException {
        BankRegistration dossier = dossierRepository.findById(dossierId);
        if (dossier == null) {
            throw new BankRegistrationNotFoundException();
        }
        return dossier;
    }

    @Override
    public BankRegistration updateIdentityDocument(String dossierId, IdentityDocument identityDocument) throws AbstractBusinessException {
        BankRegistration dossier = dossierRepository.findById(dossierId);
        if (dossier == null) {
            throw new BankRegistrationNotFoundException();
        }

        updateIdentityDocumentIntoDossier(identityDocument, dossier);
        dossierRepository.update(dossier);
        return dossier;
    }

    private static void updateIdentityDocumentIntoDossier(IdentityDocument identityDocument, BankRegistration dossier) {
        IdentityDocument dossierIdentityDocument = dossier.getIdentityDocument();
        mapDataIfNotNull(identityDocument::getDocumentType, dossierIdentityDocument::setDocumentType);
        mapDataIfNotNull(identityDocument::getNumber, dossierIdentityDocument::setNumber);
        mapDataIfNotNull(identityDocument::getValidFrom, dossierIdentityDocument::setValidFrom);
        mapDataIfNotNull(identityDocument::getValidTill, dossierIdentityDocument::setValidTill);
    }

    public static <T> void mapDataIfNotNull(Supplier<T> supplier, Consumer<T> setterMethod) {
        T suppliedValue = supplier.get();
        if (suppliedValue != null) {
            setterMethod.accept(suppliedValue);
        }
    }

    @Override
    public BankRegistration updateCustomerInformation(String dossierId, Customer customer) throws AbstractBusinessException {
        BankRegistration dossier = dossierRepository.findById(dossierId);
        if (dossier == null) {
            throw new BankRegistrationNotFoundException();
        }

        mapCustomerIntoDossier(customer, dossier);
        dossierRepository.update(dossier);
        return dossier;
    }

    private static void mapCustomerIntoDossier(Customer customer, BankRegistration dossier) {
        Customer dossierCustomer = dossier.getCustomer();
        mapDataIfNotNull(customer::getFirstName, dossierCustomer::setFirstName);
        mapDataIfNotNull(customer::getLastName, dossierCustomer::setLastName);
        mapDataIfNotNull(customer::getBirthDate, dossierCustomer::setBirthDate);
        mapDataIfNotNull(customer::getNationality, dossierCustomer::setNationality);

        Address dossierCustomerAddress = dossierCustomer.getAddress();
        Address inputAddress = customer.getAddress();
        mapDataIfNotNull(inputAddress::getCountry, dossierCustomerAddress::setCountry);
        mapDataIfNotNull(inputAddress::getZipCode, dossierCustomerAddress::setZipCode);
        mapDataIfNotNull(inputAddress::getCity, dossierCustomerAddress::setCity);
        mapDataIfNotNull(inputAddress::getStreet, dossierCustomerAddress::setStreet);
        mapDataIfNotNull(inputAddress::getHouseNumber, dossierCustomerAddress::setHouseNumber);
    }
}
