package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.CommentResponse;
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
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public CommentResponse crearComentario(CreateCommentRequest req) {

        Post post = postRepository.findById(req.getPostId())
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        User autor = userRepository.findById(req.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Comentario comentario = new Comentario();
        comentario.setPost(post);
        comentario.setAutor(autor);
        comentario.setTexto(req.getTexto());
        comentario.setCreadoEn(LocalDateTime.now());

        Comentario guardado = comentarioRepository.save(comentario);
        return CommentResponse.fromEntity(guardado);
    }

    public List<CommentResponse> listarPorPost(Long postId) {
        return comentarioRepository.findByPostIdOrderByCreadoEnAsc(postId)
                .stream()
                .map(CommentResponse::fromEntity)
                .toList();
    }
}
