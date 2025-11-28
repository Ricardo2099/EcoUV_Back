package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    // Grupos activos de una carrera
    List<Grupo> findByCarreraAndActivoTrue(Carrera carrera);

    // Grupos activos de una carrera y semestre
    List<Grupo> findByCarreraAndSemestreAndActivoTrue(Carrera carrera, Integer semestre);
}
