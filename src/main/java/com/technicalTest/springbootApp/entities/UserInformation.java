package com.technicalTest.springbootApp.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String userName;
    private LocalDate birthDate;
    private String residenceCountry;
    private String phoneNumber;
    private Gender gender;
}
