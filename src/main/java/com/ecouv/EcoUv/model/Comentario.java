package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Texto del comentario
    @Column(nullable = false, length = 600)
    private String texto;

    @Column(nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    @ManyToOne(optional = false)
    @JoinColumn(name = "autor_id")
    private User autor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}
