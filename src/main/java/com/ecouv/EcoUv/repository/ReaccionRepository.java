package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Post;
import com.ecouv.EcoUv.model.Reaccion;
import com.ecouv.EcoUv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReaccionRepository extends JpaRepository<Reaccion, Long> {

    long countByPost(Post post);

    Optional<Reaccion> findByPostAndUsuario(Post post, User usuario);

    List<Reaccion> findByPost(Post post);
}
