package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.CrearPostRequest;
import com.ecouv.EcoUv.dto.PostResponseDTO;
import com.ecouv.EcoUv.model.*;
import com.ecouv.EcoUv.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
 private final ReaccionRepository reaccionRepository;
    private final ComentarioRepository comentarioRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final GrupoRepository grupoRepository;
    private final CarreraRepository carreraRepository;
    private final PlanRepository planRepository;
    private final FacultadRepository facultadRepository;

    // ======================================================
    // CREAR POST
    // ======================================================
    public PostResponseDTO crearPost(CrearPostRequest req) {

        User autor = userRepository.findById(req.getAutorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Grupo grupo = grupoRepository.findById(req.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        Carrera carrera = carreraRepository.findById(req.getCarreraId())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        Plan plan = planRepository.findById(req.getPlanId())
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        Facultad facultad = facultadRepository.findById(req.getFacultadId())
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));

        Post post = new Post();
        post.setAutor(autor);
        post.setGrupo(grupo);
        post.setCarrera(carrera);
        post.setPlan(plan);
        post.setFacultad(facultad);
        post.setSemestre(req.getSemestre());
        post.setTipoFeed(req.getTipoFeed());
        post.setContenido(req.getContenido());
        post.setAdjuntoUrl(req.getAdjuntoUrl());

        postRepository.save(post);

        return PostResponseDTO.fromEntity(post);
    }

    // ======================================================
    // LISTAR TODOS
    // ======================================================
    public List<PostResponseDTO> listarTodos() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();
    }

    // ======================================================
    // ELIMINAR POST (solo autor)
    // ======================================================
    @Transactional
public void eliminarPost(Long postId, Long usuarioId) {

    Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("Post no encontrado"));

    if (!post.getAutor().getId().equals(usuarioId)) {
        throw new RuntimeException("No tienes permiso para eliminar este post");
    }

    // 1. Borrar reacciones asociadas
    reaccionRepository.deleteByPostId(postId);

    // 2. Borrar comentarios asociados
    comentarioRepository.deleteByPostId(postId);

    // 3. Borrar el post
    postRepository.delete(post);
}


    // ======================================================
    // EDITAR POST (solo autor)
    // ======================================================
    public PostResponseDTO editarPost(Long postId, Long usuarioId, CrearPostRequest req) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        if (!post.getAutor().getId().equals(usuarioId)) {
            throw new RuntimeException("No tienes permiso para editar este post");
        }

        post.setContenido(req.getContenido());
        post.setAdjuntoUrl(req.getAdjuntoUrl());
        post.setTipoFeed(req.getTipoFeed());

        postRepository.save(post);

        return PostResponseDTO.fromEntity(post);
    }
}
