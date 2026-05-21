package com.ilian.authcore.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongPassValidator implements ConstraintValidator<StrongPassword, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,64})");
    }


}
