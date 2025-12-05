package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.CreateCommentRequest;
import com.ecouv.EcoUv.model.Comentario;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.User;
import com.ecouv.EcoUv.repository.ComentarioRepository;
import com.ecouv.EcoUv.repository.PostRepository;
import com.ecouv.EcoUv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ComentarioRepository comentarioRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Comentario crearComentario(CreateCommentRequest req) {

        User autor = userRepository.findById(req.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Post post = postRepository.findById(req.getPostId())
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        Comentario c = new Comentario();
        c.setAutor(autor);
        c.setPost(post);
        c.setTexto(req.getTexto());
        c.setCreadoEn(LocalDateTime.now());

        return comentarioRepository.save(c);
    }

    public List<Comentario> obtenerComentarios(Long postId) {
        return comentarioRepository.findByPostIdOrderByCreadoEnDesc(postId);
    }
}
