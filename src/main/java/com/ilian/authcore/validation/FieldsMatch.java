package com.ilian.authcore.validation;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FieldsMatchValidator.class)
public @interface FieldsMatch {

    String first();
    String second();

    String message() default "Fields do not match";

    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
