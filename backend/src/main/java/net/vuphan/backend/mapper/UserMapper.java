package net.vuphan.backend.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import net.vuphan.backend.datamodel.dto.UserDto;
import net.vuphan.backend.datamodel.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(UserEntity entity);

    UserEntity toEntity(UserDto dto);

    List<UserDto> toDtos(List<UserEntity> entities);

    List<UserEntity> toEntities(List<UserDto> dtos);
}
