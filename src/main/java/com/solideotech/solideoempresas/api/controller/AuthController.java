package com.solideotech.solideoempresas.api.controller;

import com.solideotech.solideoempresas.api.dto.AccountDto;
import com.solideotech.solideoempresas.api.dto.UserDto;
import com.solideotech.solideoempresas.api.entity.Account;
import com.solideotech.solideoempresas.api.service.AccountService;
import com.solideotech.solideoempresas.api.service.UserService;
import com.solideotech.solideoempresas.api.util.JwtUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to Solideo Empresas !!";
    }

    @GetMapping("/auth")
    public ResponseEntity<UserDto> generateToken(HttpServletRequest request) throws Exception {
        String userDateEncoded = request.getHeader("authorization").split(" ")[1];
        String userDate = new String(Base64.getDecoder().decode(userDateEncoded));
        String username = userDate.split(":")[0];
        String password = userDate.split(":")[1];

        if (Strings.isNotEmpty(username) && Strings.isNotEmpty(password)) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            if(authentication.isAuthenticated()) {
                String loggerUserToken = jwtUtil.generateToken(username);
                UserDto loggerUserDto = userService.getUserByUsername(username);
                loggerUserDto.setToken(loggerUserToken);

                Account account = accountService.getLoggedUserAccount(loggerUserDto);

                if (account == null) {
                    throw new Exception("Account not found for user: " + loggerUserDto.getUsername());
                }

                AccountDto accountDto = new AccountDto();
                BeanUtils.copyProperties(account, accountDto);
                accountDto.setAccountStatus(account.getAccountStatus().name());

                loggerUserDto.setAccountDto(accountDto);

                return ResponseEntity.ok().body(loggerUserDto);
            }
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        }
        return ResponseEntity.notFound().build();
    }
}
