package org.fpl.bank_account_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = Bankaccount.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
}
