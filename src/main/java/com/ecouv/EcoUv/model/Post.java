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

    @Column(nullable = false, length = 1000)
    private String contenido;

    @Column(length = 500)
    private String adjuntoUrl;

    @Column(nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    @Column(nullable = false, length = 20)
    private String tipoFeed;

    @ManyToOne(optional = false)
    @JoinColumn(name = "autor_id")
    private User autor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @ManyToOne(optional = false)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne(optional = false)
    @JoinColumn(name = "facultad_id")
    private Facultad facultad;

    @Column(nullable = false)
    private Integer semestre;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();
}
