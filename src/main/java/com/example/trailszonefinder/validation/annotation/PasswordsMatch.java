package com.example.trailszonefinder.validation.annotation;

import com.example.trailszonefinder.validation.validator.PasswordsMatchValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordsMatchValidator.class)
public @interface PasswordsMatch {

    String message() default "Password and Confirm password must be matches!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
