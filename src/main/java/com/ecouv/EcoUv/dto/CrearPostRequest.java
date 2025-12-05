package com.ecouv.EcoUv.dto;

import lombok.Data;

@Data
public class CrearPostRequest {

    private Long autorId;
    private Long grupoId;
    private String contenido;
    private String adjuntoUrl;
    private String tipoFeed;  // GRUPO, CARRERA, PLAN, SEMESTRE, FACULTAD

}
