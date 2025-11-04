package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    // Ejemplo de búsqueda por carrera y semestre
    List<Grupo> findByCarreraAndSemestre(String carrera, Integer semestre);
}
