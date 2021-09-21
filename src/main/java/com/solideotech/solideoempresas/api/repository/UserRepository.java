package com.solideotech.solideoempresas.api.repository;

import com.solideotech.solideoempresas.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    User findUserById(int id);
    List<User> findAllByAccountId(int accountId);
}
