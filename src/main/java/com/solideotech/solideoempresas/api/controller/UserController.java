package com.solideotech.solideoempresas.api.controller;

import com.solideotech.solideoempresas.api.dto.AccountDto;
import com.solideotech.solideoempresas.api.dto.UserDto;
import com.solideotech.solideoempresas.api.dto.UserRoleDto;
import com.solideotech.solideoempresas.api.service.AccountService;
import com.solideotech.solideoempresas.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/roles")
    public ResponseEntity<List<UserRoleDto>> getAllUserRoles() {
        List<UserRoleDto> userRoleDtos = userService.getAllUserRoles();

        if (userRoleDtos != null && !userRoleDtos.isEmpty()) {
            return ResponseEntity.ok().body(userRoleDtos);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/userById")
    public ResponseEntity<UserDto> getUserById(@RequestParam Integer userId) throws Exception {

        if (userId == null) {
            throw new Exception("The userId should be present!");
        }

        UserDto userDto = userService.getUserById(userId);

        if (userDto != null) {
            return ResponseEntity.ok().body(userDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usersByAccountId")
    public ResponseEntity<List<UserDto>> getAllUsersByAccountId(@RequestParam Integer accountId) throws Exception {

        if (accountId == null) {
            throw new Exception("The accountId should be present!");
        }

        List<UserDto> users = userService.getAllUsersByAccountId(accountId);

        if (users != null && !users.isEmpty()) {
            return ResponseEntity.ok().body(users);
        }
        return ResponseEntity.notFound().build();
    }
}
