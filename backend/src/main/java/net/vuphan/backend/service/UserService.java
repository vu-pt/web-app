package net.vuphan.backend.service;

import java.util.List;

import net.vuphan.backend.datamodel.dto.UserDto;

public interface UserService {
    List<UserDto> getUsers();
}
