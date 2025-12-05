package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Comentario;
import com.ecouv.EcoUv.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByPostOrderByCreadoEnAsc(Post post);
    List<Comentario> findByPostIdOrderByCreadoEnDesc(Long postId);

}
