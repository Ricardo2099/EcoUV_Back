package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.ReaccionRequest;
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
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Reaccion darLike(ReaccionRequest req) {

        User usuario = userRepository.findById(req.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Post post = postRepository.findById(req.getPostId())
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        return reaccionRepository.findByUsuarioAndPost(usuario, post)
                .orElseGet(() -> {
                    Reaccion r = new Reaccion();
                    r.setUsuario(usuario);
                    r.setPost(post);
                    r.setCreadoEn(LocalDateTime.now());
                    return reaccionRepository.save(r);
                });
    }

    public void quitarLike(Long usuarioId, Long postId) {

        User usuario = userRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        reaccionRepository.findByUsuarioAndPost(usuario, post)
                .ifPresent(reaccionRepository::delete);
    }

    public int contarLikes(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        return reaccionRepository.countByPost(post);
    }
}
