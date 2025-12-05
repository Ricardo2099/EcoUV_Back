package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planes")
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ej: "ICIV-2020"
    @Column(length = 50, unique = true, nullable = false)
    private String clave;

    // Ej: "Plan 2020 - Ingeniería Civil"
    @Column(nullable = false, length = 200)
    private String nombre;

    // CORTAMOS el ciclo hacia Carrera
    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    @JsonIgnore
    private Carrera carrera;

    @OneToMany(mappedBy = "plan")
    private List<Grupo> grupos = new ArrayList<>();
}
