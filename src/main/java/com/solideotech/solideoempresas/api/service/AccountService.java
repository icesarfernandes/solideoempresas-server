package com.solideotech.solideoempresas.api.service;

import com.solideotech.solideoempresas.api.dto.AccountDto;
import com.solideotech.solideoempresas.api.dto.UserDto;
import com.solideotech.solideoempresas.api.entity.Account;
import com.solideotech.solideoempresas.api.entity.User;
import com.solideotech.solideoempresas.api.repository.AccountRepository;
import com.solideotech.solideoempresas.api.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public Account getLoggedUserAccount(UserDto userDto) {
        User user = userRepository.findByUsername(userDto.getUsername());
        return accountRepository.findAccountById(user.getAccountId());
    }

    public AccountDto getAccountById(int accountId) {
        Account account = accountRepository.findAccountById(accountId);
        return parseAccountToAccountDto(account);
    }

    public AccountDto parseAccountToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        accountDto.setAccountStatus(account.getAccountStatus().label);

        return accountDto;
    }
}
