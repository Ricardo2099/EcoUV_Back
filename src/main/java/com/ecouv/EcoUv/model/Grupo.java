package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "grupos")
@Data
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ej: "ICIV-301"
    @Column(nullable = false, length = 50, unique = true)
    private String clave;

    // Ej: "Grupo 301"  (el DTO usa getGrupo())
    @Column(nullable = false, length = 100)
    private String grupo;

    // Evitar recursión hacia Carrera
    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    @JsonIgnore
    private Carrera carrera;

    // Evitar recursión hacia Plan
    @ManyToOne(optional = false)
    @JoinColumn(name = "plan_id")
    @JsonIgnore
    private Plan plan;
}
