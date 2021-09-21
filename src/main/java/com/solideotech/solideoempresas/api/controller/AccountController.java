package com.solideotech.solideoempresas.api.controller;

import com.solideotech.solideoempresas.api.dto.AccountDto;
import com.solideotech.solideoempresas.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/account")
    public ResponseEntity<AccountDto> getAccountById(@RequestParam int accountId) throws Exception {
        AccountDto accountDto = accountService.getAccountById(accountId);

        if (accountDto != null) {
            return ResponseEntity.ok().body(accountDto);
        }
        return ResponseEntity.notFound().build();
    }
}
