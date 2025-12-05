package com.ecouv.EcoUv.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailInstitucionalValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailInstitucional {

    String message() default "El correo institucional no pertenece al dominio permitido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String dominio() default "@estudiantes.uv.mx";
}
