package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.NotificacionResponse;
import com.ecouv.EcoUv.model.Notificacion;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.User;
import com.ecouv.EcoUv.repository.NotificacionRepository;
import com.ecouv.EcoUv.repository.PostRepository;
import com.ecouv.EcoUv.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public NotificacionService(NotificacionRepository notificacionRepository,
                               UserRepository userRepository,
                               PostRepository postRepository) {
        this.notificacionRepository = notificacionRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void crearNotificacionComentario(Long postId, Long actorId) {
        crearNotificacion(postId, actorId, Notificacion.Tipo.COMENTARIO);
    }

    public void crearNotificacionReaccion(Long postId, Long actorId) {
        crearNotificacion(postId, actorId, Notificacion.Tipo.REACCION);
    }

    private void crearNotificacion(Long postId, Long actorId, Notificacion.Tipo tipo) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        User actor = userRepository.findById(actorId)
                .orElseThrow(() -> new RuntimeException("Usuario actor no encontrado"));

        User destinatario = post.getAutor();

        // Evitar notificación a sí mismo
        if (destinatario.getId().equals(actor.getId())) return;

        Notificacion n = new Notificacion();
        n.setTipo(tipo);
        n.setActor(actor);
        n.setDestinatario(destinatario);
        n.setPost(post);

        String msg = (tipo == Notificacion.Tipo.COMENTARIO)
                ? actor.getNombreCompleto() + " comentó tu publicación"
                : actor.getNombreCompleto() + " reaccionó a tu publicación";

        n.setMensaje(msg);

        notificacionRepository.save(n);
    }

    public Page<NotificacionResponse> listar(Long destinatarioId, int page, int size) {
        return notificacionRepository
                .findByDestinatarioIdOrderByCreadoEnDesc(destinatarioId, PageRequest.of(page, size))
                .map(NotificacionResponse::fromEntity);
    }

    public long contarNoLeidas(Long destinatarioId) {
        return notificacionRepository.countByDestinatarioIdAndLeidaFalse(destinatarioId);
    }

    public void marcarLeida(Long notificacionId, Long destinatarioId) {
        Notificacion n = notificacionRepository.findById(notificacionId)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));

        if (!n.getDestinatario().getId().equals(destinatarioId)) {
            throw new RuntimeException("No puedes modificar notificaciones de otro usuario");
        }

        n.setLeida(true);
        notificacionRepository.save(n);
    }
}
