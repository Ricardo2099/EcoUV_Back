package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carreras")
@Data
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ej: "Ingeniería Civil"
    @Column(nullable = false, unique = true, length = 150)
    private String nombre;

    // Ej: "ICIV"
    @Column(length = 20, unique = true)
    private String clave;

    // MUCHO OJO AQUÍ: cortamos el ciclo hacia Facultad
    @ManyToOne(optional = false)
    @JoinColumn(name = "facultad_id")
    @JsonIgnore
    private Facultad facultad;

    // Desde facultad SÍ queremos ver las carreras completas,
    // incluyendo planes y grupos, así que aquí NO ignoramos nada
    @OneToMany(mappedBy = "carrera")
    private List<Plan> planes = new ArrayList<>();

    @OneToMany(mappedBy = "carrera")
    private List<Grupo> grupos = new ArrayList<>();
}
