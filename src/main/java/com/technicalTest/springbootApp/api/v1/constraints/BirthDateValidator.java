package com.technicalTest.springbootApp.api.v1.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class BirthDateValidator implements ConstraintValidator<BirthDate, LocalDate> {
    @Override
    public boolean isValid(final LocalDate valueToValidate, final ConstraintValidatorContext context) {
        LocalDate today = LocalDate.now();

        return Period.between(valueToValidate, today).getYears() >= 18;
    }
}
