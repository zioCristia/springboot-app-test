package com.technicalTest.springbootApp.services;

import com.technicalTest.springbootApp.entities.UserInformation;
import com.technicalTest.springbootApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public UserInformation findById(Long id) {
        Optional<UserInformation> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent()) {
            throw new RuntimeException("User Not Found!");
        }

        return userOptional.get();
    }

    @Override
    public UserInformation createUser(UserInformation user) {
        return null;
    }
}
