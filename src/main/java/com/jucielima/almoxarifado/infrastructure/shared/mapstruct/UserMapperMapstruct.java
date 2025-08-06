package com.jucielima.almoxarifado.infrastructure.shared.mapstruct;

import com.jucielima.almoxarifado.application.dto.UserDto;
import com.jucielima.almoxarifado.domain.gateway.UserMapper;
import com.jucielima.almoxarifado.domain.model.User;
import com.jucielima.almoxarifado.infrastructure.database.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapperMapstruct extends UserMapper {
    @Override
    UserDto userToUserDto(User user);

    @Override
    User userEntityToUser(UserEntity userEntity);
}
