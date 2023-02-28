package com.technicalTest.springbootApp.repositories;

import com.technicalTest.springbootApp.entities.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<UserInformation, Long> {
}
