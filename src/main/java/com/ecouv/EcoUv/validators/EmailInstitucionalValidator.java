package com.ecouv.EcoUv.validators;

import jakarta.validation.*;

public class EmailInstitucionalValidator implements ConstraintValidator<EmailInstitucional, String> {
  private String dominio;
  @Override public void initialize(EmailInstitucional ann){ dominio = ann.dominio(); }
  @Override public boolean isValid(String value, ConstraintValidatorContext ctx){
    return value != null && value.endsWith(dominio);
  }
}
