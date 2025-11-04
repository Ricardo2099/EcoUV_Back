package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Para el feed: posts de un grupo, más nuevos primero
    List<Post> findByGrupoOrderByCreadoEnDesc(Grupo grupo);
}
