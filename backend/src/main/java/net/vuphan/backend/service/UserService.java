package net.vuphan.backend.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.vuphan.backend.datamodel.dto.UserDto;

public interface UserService extends UserDetailsService {
    List<UserDto> getUsers();

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    UserDto updateUserById(Long id,UserDto userDto);
    
    void deleteById(Long id);
}
