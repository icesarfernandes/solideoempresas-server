package com.solideotech.solideoempresas.api.repository;

import com.solideotech.solideoempresas.api.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findAccountById(int id);
}
