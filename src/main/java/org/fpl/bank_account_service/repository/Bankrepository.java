package org.fpl.bank_account_service.repository;

import org.fpl.bank_account_service.entities.Bankaccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bankrepository extends JpaRepository<Bankaccount,String> {
}
