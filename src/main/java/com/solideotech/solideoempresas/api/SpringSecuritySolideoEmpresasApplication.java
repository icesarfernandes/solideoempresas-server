package com.solideotech.solideoempresas.api;

import com.solideotech.solideoempresas.api.entity.Account;
import com.solideotech.solideoempresas.api.entity.User;
import com.solideotech.solideoempresas.api.enumeration.AccountStatusEnum;
import com.solideotech.solideoempresas.api.repository.AccountRepository;
import com.solideotech.solideoempresas.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecuritySolideoEmpresasApplication {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @PostConstruct
    public void initUsers() {
        Account account = new Account(1703, "Conta Demo", "solideotech@gmail.com", "Rua das Empresas, 123, João Pessoa, PB", true, AccountStatusEnum.ACTIVE, "27664816000176", "83988304360");
        accountRepository.save(account);

        List<User> users = Stream.of(
                new User("solideotech", "123456", "solideotech@gmail.com", "SoliDeo", "Technologies", true, 1, "MANAGER"),
                new User("lbrfernandes", "123456", "lbrfernandes@gmail.com", "Lorrana", "Fernandes", true, 1, "MANAGER_FINANCIAL"),
                new User("luisafernandes", "123456", "luisabragafernandes@gmail.com", "Luísa", "Fernandes", true, 1, "MANAGER_SALES"),
                new User("pcfernandes", "123456", "pcfernandes@gmail.com", "Paulo Cesar", "Fernandes", false, 1, "MANAGER_HUMAN_RESOURCES")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuritySolideoEmpresasApplication.class, args);
    }

}
