package com.technicalTest.springbootApp.repositories;

import com.technicalTest.springbootApp.entities.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInformation, Integer> {
}
