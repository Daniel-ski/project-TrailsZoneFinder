package com.example.trailszonefinder.validation.validator;

import com.example.trailszonefinder.validation.annotation.WithoutDigits;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WithoutDigitsValidator implements ConstraintValidator<WithoutDigits,String> {

    @Override
    public void initialize(WithoutDigits constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String fullName, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(fullName);

        return !matcher.find();
    }
}

//        return !Pattern.matches(fullName,"\\d+");
//    }

