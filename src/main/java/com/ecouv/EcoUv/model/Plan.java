package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "planes")
@Data
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ej. "PE-2020"
    @Column(nullable = false, length = 50)
    private String clave;

    @Column(nullable = false, length = 150)
    private String nombre;

    // Carrera a la que pertenece este plan
    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;
}
