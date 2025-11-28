package com.ecouv.EcoUv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCommentRequest {

    @NotNull
    private Long autorId;   // id del User que comenta

    @NotBlank
    private String texto;
}
