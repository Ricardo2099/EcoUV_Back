package com.ecouv.EcoUv.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
@Data
public class Notificacion {

    public enum Tipo {
        COMENTARIO,
        REACCION
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Tipo tipo;

    @Column(nullable = false, length = 300)
    private String mensaje;

    @Column(nullable = false)
    private Boolean leida = false;

    @Column(nullable = false)
    private LocalDateTime creadoEn = LocalDateTime.now();

    // Usuario que recibirá la notificación (autor del post)
    @ManyToOne(optional = false)
    @JoinColumn(name = "destinatario_id")
    private User destinatario;

    // Usuario que hizo la acción (comentó / reaccionó)
    @ManyToOne(optional = false)
    @JoinColumn(name = "actor_id")
    private User actor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;
}
