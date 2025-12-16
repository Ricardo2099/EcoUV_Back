package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.CrearPostRequest;
import com.ecouv.EcoUv.dto.PostResponseDTO;
import com.ecouv.EcoUv.model.*;
import com.ecouv.EcoUv.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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

    // ======================================================
    // FEED: listar posts por categoria
    // ======================================================
    public List<PostResponseDTO> listarPorGrupo(Long grupoId, String tipoFeed) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        return postRepository.findByGrupoAndTipoFeedOrderByCreadoEnDesc(grupo, tipoFeed)
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();
    }

    public List<PostResponseDTO> listarPorCarrera(Long carreraId, String tipoFeed) {
        Carrera carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        return postRepository.findByCarreraAndTipoFeedOrderByCreadoEnDesc(carrera, tipoFeed)
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();
    }

    public List<PostResponseDTO> listarPorPlan(Long planId, String tipoFeed) {
        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        return postRepository.findByPlanAndTipoFeedOrderByCreadoEnDesc(plan, tipoFeed)
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();
    }

    public List<PostResponseDTO> listarPorFacultad(Long facultadId, String tipoFeed) {
        Facultad facultad = facultadRepository.findById(facultadId)
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));

        return postRepository.findByFacultadAndTipoFeedOrderByCreadoEnDesc(facultad, tipoFeed)
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();
    }

    public List<PostResponseDTO> listarPorSemestre(Integer semestre, String tipoFeed) {
        return postRepository.findBySemestreAndTipoFeedOrderByCreadoEnDesc(semestre, tipoFeed)
                .stream()
                .map(PostResponseDTO::fromEntity)
                .toList();
    }

    // ======================================================
    // FEED MEZCLADO (por usuario)
    // - Se basa en el grupo del usuario (y su plan/carrera/facultad)
    // - Limita resultados con paginación
    // ======================================================
    public Page<PostResponseDTO> feedMixtoPorUsuario(Long userId, int page, int size) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Long grupoId = user.getGrupo().getId();
        Long planId = user.getPlan().getId();
        Long carreraId = user.getCarrera().getId();
        Long facultadId = user.getCarrera().getFacultad().getId();

        return postRepository
                .findDistinctByGrupoIdOrPlanIdOrCarreraIdOrFacultadIdOrderByCreadoEnDesc(
                        grupoId,
                        planId,
                        carreraId,
                        facultadId,
                        PageRequest.of(page, size)
                )
                .map(PostResponseDTO::fromEntity);
    }
}
