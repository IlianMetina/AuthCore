package com.ilian.authcore.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IbanValidator implements ConstraintValidator<CorrectIban, String> {

    private String iban;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("""
                /(?:IT|SM)\\d{2} ?[A-Z]\\d{3}(?: ?\\d{4}){4} ?\\d{3}|
                CY\\d{2} ?[A-Z]\\d{3}(?: ?\\d{4}){5}|
                NL\\d{2} ?[A-Z]{4}(?: ?\\d{4}){2} ?\\d{2}|
                LV\\d{2} ?[A-Z]{4}(?: ?\\d{4}){3} ?\\d|
                (?:BG|BH|GB|IE)\\d{2} ?[A-Z]{4}(?: ?\\d{4}){3} ?\\d{2}|
                GI\\d{2} ?[A-Z]{4}(?: ?\\d{4}){3} ?\\d{3}|
                RO\\d{2} ?[A-Z]{4}(?: ?\\d{4}){4}|
                KW\\d{2} ?[A-Z]{4}(?: ?\\d{4}){5} ?\\d{2}|
                MT\\d{2} ?[A-Z]{4}(?: ?\\d{4}){5} ?\\d{3}|
                NO\\d{2}(?: ?\\d{4}){4}|
                (?:DK|FI|GL|FO)\\d{2}(?: ?\\d{4}){3} ?\\d{2}|
                MK\\d{2}(?: ?\\d{4}){3} ?\\d{3}|
                (?:AT|EE|KZ|LU|XK)\\d{2}(?: ?\\d{4}){4}|
                (?:BA|HR|LI|CH|CR)\\d{2}(?: ?\\d{4}){4} ?\\d|
                (?:GE|DE|LT|ME|RS)\\d{2}(?: ?\\d{4}){4} ?\\d{2}|
                IL\\d{2}(?: ?\\d{4}){4} ?\\d{3}|
                (?:AD|CZ|ES|MD|SA)\\d{2}(?: ?\\d{4}){5}|
                PT\\d{2}(?: ?\\d{4}){5} ?\\d|
                (?:BE|IS)\\d{2}(?: ?\\d{4}){5} ?\\d{2}|
                (?:FR|MR|MC)\\d{2}(?: ?\\d{4}){5} ?\\d{3}|
                (?:AL|DO|LB|PL)\\d{2}(?: ?\\d{4}){6}|
                (?:AZ|HU)\\d{2}(?: ?\\d{4}){6} ?\\d|
                (?:GR|MU)\\d{2}(?: ?\\d{4}){6} ?\\d{2}/g""");
    }
}
