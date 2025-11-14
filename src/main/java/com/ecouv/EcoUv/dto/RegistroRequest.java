package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.validators.EmailInstitucional;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegistroRequest {

    // 1. Datos personales
    @NotBlank
    private String nombres;

    @NotBlank
    private String apellidos;

    // 2. Credenciales
    @Email
    @EmailInstitucional(dominio = "@uv.mx") // ajusta dominio si es otro
    @NotBlank
    private String emailInstitucional;

    @NotBlank
    private String matricula;

    @NotBlank
    @Size(min = 8)
    private String password;

    // 3. Datos académicos
    @NotNull
    private Long carreraId;

    @NotNull
    private Long planId;

    @NotNull
    @Min(1)
    private Integer semestre;

    @NotNull
    private Long grupoId;

    @NotBlank
    private String campus;
}
