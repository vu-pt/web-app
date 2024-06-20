package net.vuphan.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.vuphan.backend.datamodel.dto.UserDto;
import net.vuphan.backend.datamodel.entity.UserEntity;
import net.vuphan.backend.mapper.UserMapper;
import net.vuphan.backend.repository.UserRepository;
import net.vuphan.backend.service.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        return userMapper.toDtos(users);
    }
}
