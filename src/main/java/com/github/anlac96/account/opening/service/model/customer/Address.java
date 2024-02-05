package com.github.anlac96.account.opening.service.model.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String country;
    private String zipCode;
    private String city;
    private String street;
    private String houseNumber;
}
