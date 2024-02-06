package com.github.anlac96.account.opening.service.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class IdentityDocument {
    private String documentType;
    private String number;
    private LocalDate validFrom;
    private LocalDate validTill;
}
