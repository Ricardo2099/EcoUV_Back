package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupos_academicos")
@Data
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Carrera a la que pertenece el grupo (Ing. de Software, etc.)
    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    // Semestre al que corresponde este grupo: 1,2,3...
    @Column(nullable = false)
    private Integer semestre;

    // Nombre/código del grupo dentro de ese semestre, ej: "IS-302", "504"
    @Column(nullable = false, length = 30)
    private String grupo;

    // Ciclo o periodo académico, ej: "2025-1", "2025-2"
    @Column(nullable = false, length = 20)
    private String ciclo;

    // true = grupo actual en uso; false = grupo antiguo (histórico)
    @Column(nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "grupo")
    private List<User> usuarios = new ArrayList<>();

    @OneToMany(mappedBy = "grupo")
    private List<Post> posts = new ArrayList<>();
}
