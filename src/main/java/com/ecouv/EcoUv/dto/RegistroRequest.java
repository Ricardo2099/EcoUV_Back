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
    @EmailInstitucional(dominio = "@estudiantes.uv.mx")
    @NotBlank
    private String emailInstitucional;

    @NotBlank
    private String matricula;

    @NotBlank
    @Size(min = 4) // para pruebas puedes dejar 4; luego subes a 8
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
