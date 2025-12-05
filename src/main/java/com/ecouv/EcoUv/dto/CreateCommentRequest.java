package com.ecouv.EcoUv.dto;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private Long postId;
    private Long autorId;
    private String texto;
}
