package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.validators.EmailInstitucional;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegistroRequest {
  @Email @EmailInstitucional(dominio="@tuuni.edu") // <-- cambia dominio
  private String email;
  @NotBlank @Size(min=8)
  private String password;
  @NotBlank private String nombre;
  @NotNull private Long carreraId;
  @NotNull private Long planId;
  @NotNull @Min(1) @Max(12) private Integer semestre;
  @NotNull private Long grupoId;
}
