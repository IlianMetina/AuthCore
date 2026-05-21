package com.ilian.authcore.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class FieldsMatchValidator implements ConstraintValidator<FieldsMatch, Object> {

    private String firstField;
    private String secondField;

    @Override
    public void initialize(FieldsMatch contraintAnnotation){
        this.firstField = contraintAnnotation.first();
        this.secondField = contraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        try{
            String firstValue = getFieldValue(value, firstField);
            String secondValue = getFieldValue(value, secondField);
            return firstValue.equals(secondValue);

        } catch (Exception e) {
            return false;
        }
    }

    private String getFieldValue(Object value, String fieldName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        return BeanUtils.getProperty(value, fieldName);
    }
}
