package com.github.anlac96.account.opening.service.implementation;

import com.github.anlac96.account.opening.service.model.BankRegistration;
import com.github.anlac96.account.opening.service.service.BankRegistrationRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ApplicationScoped
public class InMemoryBankRegistrationRepository implements BankRegistrationRepository {

    private static Map<String, BankRegistration> inMemoryRegistrationMap = new ConcurrentHashMap<>();

    @Override
    public BankRegistration create(BankRegistration registration) {
        inMemoryRegistrationMap.put(registration.getRegistrationId(), registration);
        return registration;
    }

    @Override
    public BankRegistration findById(String registrationId) {
        return inMemoryRegistrationMap.get(registrationId);
    }

    @Override
    public BankRegistration update(BankRegistration registration) {
        return inMemoryRegistrationMap.put(registration.getRegistrationId(), registration);
    }

    @Override
    public BankRegistration delete(BankRegistration registration) {
        return inMemoryRegistrationMap.remove(registration.getRegistrationId());
    }
}
