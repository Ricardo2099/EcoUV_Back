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

        dto.setAutorId(post.getAutor().getId());
        dto.setAutorNombre(post.getAutor().getNombreCompleto());

        dto.setGrupoId(post.getGrupo().getId());
        dto.setCarreraId(post.getCarrera().getId());
        dto.setPlanId(post.getPlan().getId());
        dto.setFacultadId(post.getFacultad().getId());

        dto.setSemestre(post.getSemestre());

        return dto;
    }
}
