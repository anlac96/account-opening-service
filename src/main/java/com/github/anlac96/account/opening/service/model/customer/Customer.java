package com.github.anlac96.account.opening.service.model.customer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Customer {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String nationality;
    private Address address;
}
