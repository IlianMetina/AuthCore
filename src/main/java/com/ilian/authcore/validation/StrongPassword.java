package com.ilian.authcore.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StrongPassValidator.class)
public @interface StrongPassword {

    String message() default "The password must contain at " +
            "least 8 characters, 1 uppercase letter, number " +
            "and special character";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
