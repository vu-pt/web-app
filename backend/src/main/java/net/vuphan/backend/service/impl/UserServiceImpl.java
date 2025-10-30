package net.vuphan.backend.service.impl;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public List<UserDto> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        return userMapper.toDtos(users);
    }

    @Override
    public UserDto getUserById(Long id){
        UserEntity userEntity= userRepository.findById(id).orElse(null);
        return userMapper.toDto(userEntity);
    } 

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userDto.getNewPassword()));
        UserEntity result = userRepository.save(userEntity);
        return userMapper.toDto(result);
    }

    @Override
    public UserDto updateUserById(Long id,UserDto userUpdate){
        UserEntity userEntity=userRepository.findById(id).map(user->{
            user.setUsername(userUpdate.getUsername());
            return userRepository.save(user);
        }).orElseThrow(()->new RuntimeException("User not found with"+ id));
        return userMapper.toDto(userEntity);
    }

    @Override
    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User is not found!");
        }
        return userMapper.toUserDetail(userEntity);
    }

    
}
