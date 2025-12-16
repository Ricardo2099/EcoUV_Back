package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String autor;
    private String contenido;
    private LocalDateTime creadoEn;
    private long likes;

    public static PostDTO of(Post p, long likes) {
        String autorNombre = (p.getAutor() != null)
                ? p.getAutor().getNombreCompleto()
                : "Anónimo";

        return new PostDTO(
                p.getId(),
                autorNombre,
                p.getContenido(),
                p.getCreadoEn(),
                likes
        );
    }
}
