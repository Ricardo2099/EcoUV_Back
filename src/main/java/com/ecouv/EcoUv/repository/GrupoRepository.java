package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Grupo;
import com.ecouv.EcoUv.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    List<Grupo> findByCarrera(Carrera carrera);

    List<Grupo> findByPlan(Plan plan);

}
