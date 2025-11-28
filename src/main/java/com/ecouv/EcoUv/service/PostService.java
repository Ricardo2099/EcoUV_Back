package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.CreateCommentRequest;
import com.ecouv.EcoUv.dto.CreatePostRequest;
import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Comentario;
import com.ecouv.EcoUv.model.Grupo;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.User;
import com.ecouv.EcoUv.repository.ComentarioRepository;
import com.ecouv.EcoUv.repository.GrupoRepository;
import com.ecouv.EcoUv.repository.PostRepository;
import com.ecouv.EcoUv.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ComentarioRepository comentarioRepository;
    private final UserRepository userRepository;
    private final GrupoRepository grupoRepository;

    /**
     * Crear un post nuevo asociado a un usuario.
     * El grupo se toma del usuario.
     */
    public Post crearPost(CreatePostRequest req) {

        User autor = userRepository.findById(req.getAutorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Grupo grupo = autor.getGrupo();
        if (grupo == null) {
            throw new RuntimeException("El usuario no tiene grupo asignado");
        }

        Post post = new Post();
        post.setAutor(autor);
        post.setGrupo(grupo);
        post.setContenido(req.getContenido());
        post.setAdjuntoUrl(req.getAdjuntoUrl());
        post.setCreadoEn(LocalDateTime.now());

        return postRepository.save(post);
    }

    /**
     * Feed por grupo (muro del salón actual del usuario).
     */
    public List<Post> feedDeUsuarioPorGrupo(Long userId) {
        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Grupo grupo = usuario.getGrupo();
        if (grupo == null) {
            throw new RuntimeException("El usuario no tiene grupo asignado");
        }

        return postRepository.findByGrupoOrderByCreadoEnDesc(grupo);
    }

    /**
     * Feed por carrera (todos los grupos/semestres de la misma carrera).
     */
    public List<Post> feedDeUsuarioPorCarrera(Long userId) {
        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Carrera carrera = usuario.getCarrera();
        if (carrera == null) {
            throw new RuntimeException("El usuario no tiene carrera asignada");
        }

        return postRepository.findByGrupo_CarreraOrderByCreadoEnDesc(carrera);
    }

    /**
     * Feed por carrera + semestre (ej. todos los grupos de 3er semestre de Ing. Software).
     */
    public List<Post> feedDeUsuarioPorCarreraYSemestre(Long userId) {
        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Carrera carrera = usuario.getCarrera();
        if (carrera == null) {
            throw new RuntimeException("El usuario no tiene carrera asignada");
        }

        Integer semestre = usuario.getSemestre();
        if (semestre == null) {
            throw new RuntimeException("El usuario no tiene semestre definido");
        }

        return postRepository.findByGrupo_CarreraAndGrupo_SemestreOrderByCreadoEnDesc(
                carrera, semestre
        );
    }

    /**
     * Mis publicaciones: posts creados por el usuario.
     */
    public List<Post> postsDeUsuario(Long userId) {
        User usuario = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return postRepository.findByAutorOrderByCreadoEnDesc(usuario);
    }

    /**
     * Crear comentario en un post.
     */
    public Comentario crearComentario(Long postId, CreateCommentRequest req) {

        User autor = userRepository.findById(req.getAutorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        Comentario comentario = new Comentario();
        comentario.setAutor(autor);
        comentario.setPost(post);
        comentario.setTexto(req.getTexto());
        comentario.setCreadoEn(LocalDateTime.now());

        return comentarioRepository.save(comentario);
    }

    /**
     * Listar comentarios de un post.
     */
    public List<Comentario> comentariosDePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        return comentarioRepository.findByPostOrderByCreadoEnAsc(post);
    }
}
