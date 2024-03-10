package com.github.anlac96.account.opening.service.api.converter;

import com.github.anlac96.account.opening.service.dto.GetRegistrationResponse;
import com.github.anlac96.account.opening.service.model.BankRegistration;
import org.mapstruct.Mapper;

@Mapper
public interface RegistrationConverter {

    GetRegistrationResponse toRegistrationResponse(BankRegistration bankRegistration);
}
