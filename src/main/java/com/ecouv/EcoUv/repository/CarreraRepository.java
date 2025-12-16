package com.ecouv.EcoUv.repository;

import com.ecouv.EcoUv.model.Carrera;
import com.ecouv.EcoUv.model.Facultad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera, Long> {

    List<Carrera> findByFacultad(Facultad facultad);
}
