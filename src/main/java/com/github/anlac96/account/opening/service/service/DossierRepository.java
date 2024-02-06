package com.github.anlac96.account.opening.service.service;

import com.github.anlac96.account.opening.service.model.BankAccountDossier;

public interface DossierRepository {
    BankAccountDossier create(BankAccountDossier dossier);

    BankAccountDossier findById(String dossierId);

    BankAccountDossier update(BankAccountDossier dossier);

    BankAccountDossier delete(BankAccountDossier dossier);
}
