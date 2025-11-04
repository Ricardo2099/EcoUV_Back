package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Para autenticación más adelante
    Optional<User> findByUsername(String username);
}
