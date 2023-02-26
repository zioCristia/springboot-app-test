package com.technicalTest.springbootApp.repository;

import com.technicalTest.springbootApp.entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInformation, Integer> {
}
