package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(
    name = "reacciones",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "post_id"})
    }
)
@Data
public class Reaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Usuario que reacciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id")
    private User usuario;

    // Post al que reacciona
    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    // Momento en que puso el like/corazón
    @Column(nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();
}
