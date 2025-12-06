package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    void deleteByPostId(Long postId);

    // Lista comentarios de un post, ordenados por fecha de creación ascendente
    List<Comentario> findByPostIdOrderByCreadoEnAsc(Long postId);
}
