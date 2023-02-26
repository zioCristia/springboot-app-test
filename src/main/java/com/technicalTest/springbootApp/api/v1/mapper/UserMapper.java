package com.technicalTest.springbootApp.api.v1.mapper;

import com.technicalTest.springbootApp.api.v1.model.UserDTO;
import com.technicalTest.springbootApp.entities.UserInformation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(UserInformation category);
}
