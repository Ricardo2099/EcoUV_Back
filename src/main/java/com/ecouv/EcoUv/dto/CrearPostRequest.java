package com.ecouv.EcoUv.dto;

import lombok.Data;

@Data
public class CrearPostRequest {
    private Long autorId;
    private Long grupoId;
    private Long planId;
    private Long carreraId;
    private Long facultadId;
    private Integer semestre;
    private String tipoFeed;
    private String contenido;
    private String adjuntoUrl;
}
