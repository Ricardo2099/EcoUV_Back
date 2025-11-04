package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.User;
import com.ecouv.EcoUv.model.Grupo;
import com.ecouv.EcoUv.repository.PostRepository;
import com.ecouv.EcoUv.repository.UserRepository;
import com.ecouv.EcoUv.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final GrupoRepository grupoRepository;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository,
                       GrupoRepository grupoRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.grupoRepository = grupoRepository;
    }

    // Crear un post nuevo
    public Post crearPost(Long userId, Long grupoId, String contenido, String adjuntoUrl) {

        User autor = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        Post post = new Post();
        post.setAutor(autor);
        post.setGrupo(grupo);
        post.setContenido(contenido);
        post.setAdjuntoUrl(adjuntoUrl);

        return postRepository.save(post);
    }

    // Obtener feed de un grupo
    public List<Post> feedDeGrupo(Long grupoId) {

        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        return postRepository.findByGrupoOrderByCreadoEnDesc(grupo);
    }
}
