package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Grupo;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Feed: posts de un grupo, más recientes primero
    List<Post> findByGrupoOrderByCreadoEnDesc(Grupo grupo);

    // Mis publicaciones: posts de un autor
    List<Post> findByAutorOrderByCreadoEnDesc(User autor);
}
