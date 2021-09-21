package com.solideotech.solideoempresas.api.service;

import com.solideotech.solideoempresas.api.dto.UserDto;
import com.solideotech.solideoempresas.api.dto.UserRoleDto;
import com.solideotech.solideoempresas.api.entity.User;
import com.solideotech.solideoempresas.api.enumeration.UserRoleEnum;
import com.solideotech.solideoempresas.api.enumeration.UserStatusEnum;
import com.solideotech.solideoempresas.api.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto getUserById(Integer id) {
        User user = userRepository.findUserById(id);
        return parseUserToUserDto(user);
    }

    public UserDto getUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return parseUserToUserDto(user);
    }

    public List<UserDto> getAllUsersByAccountId(Integer accountId) {
        List<User> users = userRepository.findAllByAccountId(accountId);

        List<UserDto> userDtos = new ArrayList<>();
        users.forEach(user -> {
            userDtos.add(parseUserToUserDto(user));
        });
        return userDtos;
    }

    public UserDto parseUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        userDto.setRole(new UserRoleDto(UserRoleEnum.valueOf(user.getRole()).name(), UserRoleEnum.valueOf(user.getRole()).label));
        userDto.setStatus(UserStatusEnum.valueOf(user.getActive() ? "ACTIVE" : "INACTIVE").label);
        return userDto;
    }

    public List<UserRoleDto> getAllUserRoles() {
        List<UserRoleDto> userRoleDtos = new ArrayList<>();
        for (UserRoleEnum userRoleEnum : UserRoleEnum.values()) {
            UserRoleDto userRoleDto = new UserRoleDto();
            userRoleDto.setCode(userRoleEnum.name());
            userRoleDto.setLabel(userRoleEnum.label);

            userRoleDtos.add(userRoleDto);
        }

        return userRoleDtos;
    }
}
