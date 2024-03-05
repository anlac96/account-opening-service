package com.github.anlac96.account.opening.service.restapi.api;

import com.github.anlac96.account.opening.service.api.RegistrationsApi;
import com.github.anlac96.account.opening.service.dto.CreateRegistrationResponse;
import com.github.anlac96.account.opening.service.dto.GetRegistrationResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;

@ApplicationScoped
@Path("/registrations")
public class RegistrationApiImpl implements RegistrationsApi {
    @Override
    public CreateRegistrationResponse createRegistration() {
        return new CreateRegistrationResponse().registrationId("hello-quarkus");
    }

    @Override
    public GetRegistrationResponse getRegistration(String s) {
        return new GetRegistrationResponse().registrationId("hello-quarkus");
    }
}
