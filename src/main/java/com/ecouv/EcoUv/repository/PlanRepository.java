package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    List<Plan> findByCarrera(Carrera carrera);
}
