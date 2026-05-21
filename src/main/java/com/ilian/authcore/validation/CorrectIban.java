package com.ilian.authcore.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IbanValidator.class)
public @interface CorrectIban {

    String first();
    String second();

    String message() default "IBAN is invalid";

    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
