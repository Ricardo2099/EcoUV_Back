package com.ecouv.EcoUv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCommentRequest {

    private Long postId;
    private Long autorId;
    private String texto;
}
