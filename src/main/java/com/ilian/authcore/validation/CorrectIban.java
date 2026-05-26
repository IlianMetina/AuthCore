package com.ilian.authcore.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IbanValidator.class)
public @interface CorrectIban {

    String first();
    String second();

    String message() default "IBAN is invalid";

    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
