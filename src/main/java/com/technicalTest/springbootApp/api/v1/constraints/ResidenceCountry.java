package com.technicalTest.springbootApp.api.v1.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ResidenceCountryValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ResidenceCountry {
    String message() default "{com.technicalTest.springbootApp.api.v1.constraints.ResidenceCountry.message}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};
}
