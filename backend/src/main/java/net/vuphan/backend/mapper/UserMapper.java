package net.vuphan.backend.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import net.vuphan.backend.datamodel.dto.UserDetailsDto;
import net.vuphan.backend.datamodel.dto.UserDto;
import net.vuphan.backend.datamodel.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "authorities", expression = "java(entity.getUserRoles().stream().map(t -> t.getRole().getName()).collect(java.util.stream.Collectors.joining(\"::\")))")
    UserDetailsDto toUserDetail(UserEntity entity);

    
    @Mapping(target = "password", ignore = true)
    UserDto toDto(UserEntity entity);

    @Mapping(target = "password", ignore = true)
    UserEntity toEntity(UserDto dto);

    List<UserDto> toDtos(List<UserEntity> entities);

    List<UserEntity> toEntities(List<UserDto> dtos);
}
