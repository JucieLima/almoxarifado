package com.jucielima.almoxarifado.domain.gateway;

import com.jucielima.almoxarifado.application.dto.UserDto;
import com.jucielima.almoxarifado.domain.model.User;
import com.jucielima.almoxarifado.infrastructure.database.entities.UserEntity;

public interface UserMapper {
    UserDto userToUserDto(User user);
    User userEntityToUser(UserEntity userEntity);
}
