package com.technicalTest.springbootApp.api.v1.model;

import com.technicalTest.springbootApp.api.v1.constraints.BirthDate;
import com.technicalTest.springbootApp.api.v1.constraints.ResidenceCountry;
import com.technicalTest.springbootApp.entities.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    @NotBlank
    private String userName;

    @NotNull(message = "The date of birth is required.")
    @BirthDate(message = "User must be at least 18 years old")
    private LocalDate birthDate;

    @NotBlank
    @ResidenceCountry(message = "User must be a France citizen")
    private String residenceCountry;

    @Size(min = 8, max = 14)
    private String phoneNumber;

    private Gender gender;
}
