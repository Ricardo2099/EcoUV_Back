package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.model.Comentario;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponse {

    private Long id;
    private String autor;
    private String texto;
    private LocalDateTime creadoEn;

    public static CommentResponse fromEntity(Comentario c) {
        CommentResponse dto = new CommentResponse();
        dto.setId(c.getId());
        dto.setAutor(c.getAutor() != null ? c.getAutor().getNombreCompleto() : "Anónimo");
        dto.setTexto(c.getTexto());
        dto.setCreadoEn(c.getCreadoEn());
        return dto;
    }
}
