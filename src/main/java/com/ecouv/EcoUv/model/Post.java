package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Texto principal del post: aviso, duda, recurso, etc.
    @Column(nullable = false, length = 1000)
    private String contenido;

    // Archivo o enlace opcional (pdf, drive, imagen, etc.)
    private String adjuntoUrl;

    // Fecha/hora creación
    @Column(nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    // Quién publicó
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private User autor;

    // A qué grupo académico pertenece este post
    @ManyToOne
    @JoinColumn(name = "grupo_id", nullable = false)
    private Grupo grupo;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentarios;

    public Post() {}

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public String getAdjuntoUrl() { return adjuntoUrl; }
    public void setAdjuntoUrl(String adjuntoUrl) { this.adjuntoUrl = adjuntoUrl; }

    public LocalDateTime getCreadoEn() { return creadoEn; }
    public void setCreadoEn(LocalDateTime creadoEn) { this.creadoEn = creadoEn; }

    public User getAutor() { return autor; }
    public void setAutor(User autor) { this.autor = autor; }

    public Grupo getGrupo() { return grupo; }
    public void setGrupo(Grupo grupo) { this.grupo = grupo; }

    public List<Comentario> getComentarios() { return comentarios; }
    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }
}
