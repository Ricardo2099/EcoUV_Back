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

    // Ej. "2020", "PE-2019", etc.
    @Column(nullable = false, length = 50)
    private String clave;

    @Column(nullable = false, length = 150)
    private String nombre;
}
