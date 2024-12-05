package com.example.trailszonefinder.validation.validator;

import com.example.trailszonefinder.validation.annotation.PasswordsMatch;
import com.example.trailszonefinder.web.dto.UserRegisterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, UserRegisterDTO> {

    private String message;


    @Override
    public void initialize(PasswordsMatch constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(UserRegisterDTO userRegisterDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (userRegisterDTO.getPassword() == null || userRegisterDTO.getConfirmPassword() == null){
            return true;
        }

        boolean isMatches = userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword());

        if (!isMatches){
            constraintValidatorContext
                    .unwrap(HibernateConstraintValidatorContext.class)
                    .buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return isMatches;
    }
}
