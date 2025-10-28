package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupos_academicos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ej: "Ing. Software"
    @Column(nullable = false)
    private String carrera;

    // Ej: 3,4,5...
    @Column(nullable = false)
    private Integer semestre;

    // Ej: "A", "B", "Nocturno"
    @Column(nullable = false)
    private String grupo;

    @OneToMany(mappedBy = "grupo")
    private List<Post> posts;

    public Grupo() {}

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }

    public String getGrupo() { return grupo; }
    public void setGrupo(String grupo) { this.grupo = grupo; }
}
