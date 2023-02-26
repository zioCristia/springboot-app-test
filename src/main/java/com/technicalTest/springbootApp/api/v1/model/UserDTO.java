package com.technicalTest.springbootApp.api.v1.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {
    private Long id;
    private String userName;
    private LocalDate birthDate;
    private String residenceCountry;
}
