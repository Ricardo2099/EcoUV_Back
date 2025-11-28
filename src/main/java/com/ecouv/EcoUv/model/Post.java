package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Texto principal del post: aviso, duda, recurso, etc.
    @Column(nullable = false, length = 1000)
    private String contenido;

    // URL de imagen/archivo adjunto (opcional)
    @Column(length = 500)
    private String adjuntoUrl;

    @Column(nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    // Autor del post
    @ManyToOne(optional = false)
    @JoinColumn(name = "autor_id")
    private User autor;

    // Grupo académico al que pertenece el post
    @ManyToOne(optional = false)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    // Comentarios del post
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();
}
