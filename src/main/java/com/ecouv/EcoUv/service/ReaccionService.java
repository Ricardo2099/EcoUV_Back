package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.Reaccion;
import com.ecouv.EcoUv.model.User;
import com.ecouv.EcoUv.repository.PostRepository;
import com.ecouv.EcoUv.repository.ReaccionRepository;
import com.ecouv.EcoUv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReaccionService {

    private final ReaccionRepository reaccionRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    /**
     * Hace toggle de la reacción:
     * - Si el usuario ya reaccionó a ese post, se elimina la reacción.
     * - Si no ha reaccionado, se crea.
     * Devuelve el número total de reacciones del post después del cambio.
     */
    public long toggleReaccion(Long postId, Long usuarioId) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        User usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        var existenteOpt = reaccionRepository.findByPostAndUsuario(post, usuario);

        if (existenteOpt.isPresent()) {
            // Ya había like -> lo quitamos
            reaccionRepository.delete(existenteOpt.get());
        } else {
            // No había -> lo creamos
            Reaccion r = new Reaccion();
            r.setPost(post);
            r.setUsuario(usuario);
            r.setCreadoEn(LocalDateTime.now());
            reaccionRepository.save(r);
        }

        return reaccionRepository.countByPost(post);
    }

    /**
     * Obtiene el número de reacciones de un post.
     */
    public long contarReaccionesDePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        return reaccionRepository.countByPost(post);
    }
}
