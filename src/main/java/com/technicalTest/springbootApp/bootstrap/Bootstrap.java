package com.technicalTest.springbootApp.bootstrap;

import com.technicalTest.springbootApp.entities.UserInformation;
import com.technicalTest.springbootApp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        loadUsers();
    }

    public void loadUsers() {
        UserInformation marco = new UserInformation();
        marco.setUserName("Marco");

        UserInformation luca = new UserInformation();
        luca.setUserName("Luca");

        userRepository.save(marco);
        userRepository.save(luca);

        System.out.println("Users Loaded: " + userRepository.count());
    }
}
