package com.github.anlac96.account.opening.service.api;

import com.github.anlac96.account.opening.service.api.converter.ApiConverterFactory;
import com.github.anlac96.account.opening.service.dto.CreateRegistrationResponse;
import com.github.anlac96.account.opening.service.dto.GetRegistrationResponse;
import com.github.anlac96.account.opening.service.model.BankRegistration;
import com.github.anlac96.account.opening.service.service.BankRegistrationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("/registrations")
public class RegistrationApiImpl implements RegistrationsApi {

    private BankRegistrationService bankRegistrationService;

    @Inject
    public RegistrationApiImpl(BankRegistrationService bankRegistrationService) {
        this.bankRegistrationService = bankRegistrationService;
    }

    @Override
    public CreateRegistrationResponse createRegistration() {
        BankRegistration newRegistration = bankRegistrationService.createNewRegistration();
        return new CreateRegistrationResponse()
                .registrationId(newRegistration.getRegistrationId());
    }

    @Override
    public GetRegistrationResponse getRegistration(String registrationId) {
        BankRegistration registration = bankRegistrationService.getRegistrationById(registrationId);
        return ApiConverterFactory.getInstance().getRegistrationConverter().toRegistrationResponse(registration);
    }
}
