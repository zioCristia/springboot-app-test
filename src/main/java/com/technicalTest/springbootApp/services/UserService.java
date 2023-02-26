package com.technicalTest.springbootApp.services;

import com.technicalTest.springbootApp.entities.UserInformation;

public interface UserService {
    UserInformation findById(Long id);
    UserInformation createUser(UserInformation user);
}
