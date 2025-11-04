package com.ecouv.EcoUv.validators;

import jakarta.validation.*;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailInstitucionalValidator.class)
public @interface EmailInstitucional {
  String message() default "El correo debe ser institucional";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
  String dominio() default "@tuuni.edu";
}
