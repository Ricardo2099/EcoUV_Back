package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Texto del comentario
    @Column(nullable = false, length = 600)
    private String texto;

    // Fecha/hora
    @Column(nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    // Autor del comentario
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private User autor;

    // Post al que responde
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Comentario() {}

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public LocalDateTime getCreadoEn() { return creadoEn; }
    public void setCreadoEn(LocalDateTime creadoEn) { this.creadoEn = creadoEn; }

    public User getAutor() { return autor; }
    public void setAutor(User autor) { this.autor = autor; }

    public Post getPost() { return post; }
    public void setPost(Post post) { this.post = post; }
}
