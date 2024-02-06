package com.github.anlac96.account.opening.service.model;

import com.github.anlac96.account.opening.service.model.customer.Customer;
import com.github.anlac96.account.opening.service.model.product.ProductAccount;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BankAccountDossier {
    private String dossierId;
    private Customer customer;
    private IdentityDocument identityDocument;
    private List<ProductAccount> productAccounts;
}
