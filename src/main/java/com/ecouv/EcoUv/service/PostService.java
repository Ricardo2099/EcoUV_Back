package com.ecouv.EcoUv.service;

import com.ecouv.EcoUv.dto.CrearPostRequest;
import com.ecouv.EcoUv.model.*;
import com.ecouv.EcoUv.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final GrupoRepository grupoRepository;
    private final CarreraRepository carreraRepository;
    private final PlanRepository planRepository;
    private final FacultadRepository facultadRepository;

    public Post crearPost(CrearPostRequest req) {

        User autor = userRepository.findById(req.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Grupo grupo = grupoRepository.findById(req.getGrupoId())
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        Post p = new Post();
        p.setAutor(autor);
        p.setGrupo(grupo);
        p.setContenido(req.getContenido());
        p.setAdjuntoUrl(req.getAdjuntoUrl());
        p.setTipoFeed(req.getTipoFeed());

        p.setCarrera(autor.getCarrera());
        p.setPlan(autor.getPlan());
        p.setFacultad(autor.getCarrera().getFacultad());
        p.setSemestre(autor.getSemestre());
        p.setCreadoEn(LocalDateTime.now());

        return postRepository.save(p);
    }

    public Post editarPost(Long id, CrearPostRequest req) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post no encontrado"));

        post.setContenido(req.getContenido());
        post.setAdjuntoUrl(req.getAdjuntoUrl());
        post.setTipoFeed(req.getTipoFeed());

        return postRepository.save(post);
    }

    public void eliminarPost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new RuntimeException("Post no encontrado");
        }
        postRepository.deleteById(id);
    }

    public List<Post> feedGrupo(Long grupoId) {
        Grupo g = grupoRepository.findById(grupoId).orElseThrow();
        return postRepository.findByGrupoAndTipoFeedOrderByCreadoEnDesc(g, "GRUPO");
    }

    public List<Post> feedCarrera(Long carreraId) {
        Carrera c = carreraRepository.findById(carreraId).orElseThrow();
        return postRepository.findByCarreraAndTipoFeedOrderByCreadoEnDesc(c, "CARRERA");
    }

    public List<Post> feedPlan(Long planId) {
        Plan p = planRepository.findById(planId).orElseThrow();
        return postRepository.findByPlanAndTipoFeedOrderByCreadoEnDesc(p, "PLAN");
    }

    public List<Post> feedFacultad(Long facultadId) {
        Facultad f = facultadRepository.findById(facultadId).orElseThrow();
        return postRepository.findByFacultadAndTipoFeedOrderByCreadoEnDesc(f, "FACULTAD");
    }

    public List<Post> feedSemestre(Integer sem) {
        return postRepository.findBySemestreAndTipoFeedOrderByCreadoEnDesc(sem, "SEMESTRE");
    }
}
