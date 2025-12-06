package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Reaccion;
import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface ReaccionRepository extends JpaRepository<Reaccion, Long> {

    void deleteByPostId(Long postId);

    Optional<Reaccion> findByUsuarioAndPost(User usuario, Post post);

    Integer countByPost(Post post);

    List<Reaccion> findByPost(Post post);
}
