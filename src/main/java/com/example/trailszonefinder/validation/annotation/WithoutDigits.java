package com.example.trailszonefinder.validation.annotation;

import com.example.trailszonefinder.validation.validator.WithoutDigitsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = WithoutDigitsValidator.class )
public @interface WithoutDigits {

    String message() default "Full Name cannot contain digits!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
