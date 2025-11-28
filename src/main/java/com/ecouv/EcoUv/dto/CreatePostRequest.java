package com.ecouv.EcoUv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePostRequest {

    @NotNull
    private Long autorId;      // id del User que crea el post

    @NotBlank
    private String contenido;

    // opcional: URL de adjunto (imagen, pdf, etc.)
    private String adjuntoUrl;
}
