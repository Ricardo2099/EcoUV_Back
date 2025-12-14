package com.ecouv.EcoUv.dto;

import com.ecouv.EcoUv.model.Notificacion;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NotificacionResponse {
    private Long id;
    private String tipo;
    private String mensaje;
    private Boolean leida;
    private LocalDateTime creadoEn;

    private Long postId;

    private Long actorId;
    private String actorNombre;

    public static NotificacionResponse fromEntity(Notificacion n) {
        NotificacionResponse dto = new NotificacionResponse();
        dto.setId(n.getId());
        dto.setTipo(n.getTipo().name());
        dto.setMensaje(n.getMensaje());
        dto.setLeida(n.getLeida());
        dto.setCreadoEn(n.getCreadoEn());
        dto.setPostId(n.getPost().getId());
        dto.setActorId(n.getActor().getId());
        dto.setActorNombre(n.getActor().getNombreCompleto());
        return dto;
    }
}
