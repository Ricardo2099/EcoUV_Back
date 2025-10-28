package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users") // "user" es palabra reservada en Postgres
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre; // Ej: "Juan Pérez"

    @Column(nullable = false)
    private String carrera; // Ej: "Ing. Software"

    @Column(nullable = false)
    private Integer semestre; // Ej: 3,4,5...

    @Column(nullable = false)
    private String grupoAcademico; // Ej: "Grupo A"

    @Column(nullable = false, unique = true)
    private String username; // matrícula o correo UV

    @Column(nullable = false)
    private String passwordHash; // guardamos hash, no texto plano

    @OneToMany(mappedBy = "autor")
    private List<Post> posts;

    @OneToMany(mappedBy = "autor")
    private List<Comentario> comentarios;

    public User() {}

    // Getters y setters básicos
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }

    public String getGrupoAcademico() { return grupoAcademico; }
    public void setGrupoAcademico(String grupoAcademico) { this.grupoAcademico = grupoAcademico; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
}
