package com.ecouv.EcoUv.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailInstitucionalValidator implements ConstraintValidator<EmailInstitucional, String> {

    private String dominio;

    @Override
    public void initialize(EmailInstitucional constraintAnnotation) {
        this.dominio = constraintAnnotation.dominio();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) return false;

        return email.toLowerCase().endsWith(dominio.toLowerCase());
    }
}
