package com.github.anlac96.account.opening.service.implementation;

import com.github.anlac96.account.opening.service.model.BankAccountDossier;
import com.github.anlac96.account.opening.service.service.DossierRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class InMemoryDossierRepository implements DossierRepository {

    private static Map<String, BankAccountDossier> inMemoryDossierMap = new ConcurrentHashMap<>();

    @Override
    public BankAccountDossier create(BankAccountDossier dossier) {
        return inMemoryDossierMap.put(dossier.getDossierId(), dossier);
    }

    @Override
    public BankAccountDossier findById(String dossierId) {
        return inMemoryDossierMap.get(dossierId);
    }

    @Override
    public BankAccountDossier update(BankAccountDossier dossier) {
        return inMemoryDossierMap.put(dossier.getDossierId(), dossier);
    }

    @Override
    public BankAccountDossier delete(BankAccountDossier dossier) {
        return inMemoryDossierMap.remove(dossier.getDossierId());
    }
}
