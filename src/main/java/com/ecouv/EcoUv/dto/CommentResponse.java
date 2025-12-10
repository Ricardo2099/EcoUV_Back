package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.model.Comentario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {

    private Long id;
    private String texto;
    private LocalDateTime creadoEn;

    private Long autorId;
    private String autorNombre;

    public static CommentResponse fromEntity(Comentario c) {
        return CommentResponse.builder()
                .id(c.getId())
                .texto(c.getTexto())
                .creadoEn(c.getCreadoEn())
                .autorId(c.getAutor().getId())
                .autorNombre(c.getAutor().getNombres() + " " + c.getAutor().getApellidos())
                .build();
    }
}
