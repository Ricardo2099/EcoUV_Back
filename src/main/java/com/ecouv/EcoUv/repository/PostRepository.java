package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByGrupoAndTipoFeedOrderByCreadoEnDesc(Grupo grupo, String tipoFeed);

    List<Post> findByCarreraAndTipoFeedOrderByCreadoEnDesc(Carrera carrera, String tipoFeed);

    List<Post> findByPlanAndTipoFeedOrderByCreadoEnDesc(Plan plan, String tipoFeed);

    List<Post> findByFacultadAndTipoFeedOrderByCreadoEnDesc(Facultad facultad, String tipoFeed);

    List<Post> findBySemestreAndTipoFeedOrderByCreadoEnDesc(Integer semestre, String tipoFeed);
}
