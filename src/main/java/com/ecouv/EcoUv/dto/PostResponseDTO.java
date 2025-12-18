package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.model.Post;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDTO {

    private Long id;
    private String contenido;
    private String adjuntoUrl;
    private LocalDateTime creadoEn;
    private String tipoFeed;

    private Long autorId;
    private String autorNombre;

    private Long grupoId;
    private Long carreraId;
    private Long planId;
    private Long facultadId;

    private Integer semestre;

    // ======================================================
    // MÉTODO QUE EL SERVICIO NECESITA
    // ======================================================
public static PostResponseDTO fromEntity(Post post) {
    PostResponseDTO dto = new PostResponseDTO();

    dto.setId(post.getId());
    dto.setContenido(post.getContenido());
    dto.setAdjuntoUrl(post.getAdjuntoUrl());
    dto.setCreadoEn(post.getCreadoEn());
    dto.setTipoFeed(post.getTipoFeed());

    if (post.getAutor() != null) {
        dto.setAutorId(post.getAutor().getId());
        dto.setAutorNombre(post.getAutor().getNombreCompleto());
    }

    // ===== RELACIONES (NULL SAFE) =====
    dto.setGrupoId(post.getGrupo() != null ? post.getGrupo().getId() : null);
    dto.setCarreraId(post.getCarrera() != null ? post.getCarrera().getId() : null);
    dto.setPlanId(post.getPlan() != null ? post.getPlan().getId() : null);
    dto.setFacultadId(post.getFacultad() != null ? post.getFacultad().getId() : null);

    dto.setSemestre(post.getSemestre());

    return dto;
}

}
