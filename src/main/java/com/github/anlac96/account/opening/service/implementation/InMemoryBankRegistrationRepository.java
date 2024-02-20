package com.github.anlac96.account.opening.service.implementation;

import com.github.anlac96.account.opening.service.model.BankRegistration;
import com.github.anlac96.account.opening.service.service.BankRegistrationRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class InMemoryBankRegistrationRepository implements BankRegistrationRepository {

    private static Map<String, BankRegistration> inMemoryDossierMap = new ConcurrentHashMap<>();

    @Override
    public BankRegistration create(BankRegistration dossier) {
        inMemoryDossierMap.put(dossier.getDossierId(), dossier);
        return dossier;
    }

    @Override
    public BankRegistration findById(String dossierId) {
        return inMemoryDossierMap.get(dossierId);
    }

    @Override
    public BankRegistration update(BankRegistration dossier) {
        return inMemoryDossierMap.put(dossier.getDossierId(), dossier);
    }

    @Override
    public BankRegistration delete(BankRegistration dossier) {
        return inMemoryDossierMap.remove(dossier.getDossierId());
    }
}
