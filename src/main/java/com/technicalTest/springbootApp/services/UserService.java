package com.technicalTest.springbootApp.services;

import com.technicalTest.springbootApp.api.v1.model.UserDTO;
import com.technicalTest.springbootApp.entities.UserInformation;

public interface UserService {
    UserDTO findById(Long id);
    UserDTO createUser(UserDTO userDTO);
}
