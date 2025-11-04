package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Comentario;
import com.ecouv.EcoUv.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    // Listar los comentarios de un post, más viejos primero
    List<Comentario> findByPostOrderByCreadoEnAsc(Post post);
}
