package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facultades")
@Data
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ej: "Facultad de Ingeniería"
    @Column(nullable = false, unique = true, length = 150)
    private String nombre;

    // Ej: "FI"
    @Column(length = 20, unique = true)
    private String clave;

    @OneToMany(mappedBy = "facultad")
    private List<Carrera> carreras = new ArrayList<>();
}
