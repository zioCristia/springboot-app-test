package com.technicalTest.springbootApp.api.v1.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ResidenceCountryValidator implements ConstraintValidator<ResidenceCountry, String> {
    @Override
    public boolean isValid(final String residenceCountry, final ConstraintValidatorContext constraintValidatorContext) {
        return "France".equals(residenceCountry) || "france".equals(residenceCountry) || "FRANCE".equals(residenceCountry);
    }
}
