package com.ecouv.EcoUv.controller;

import com.ecouv.EcoUv.model.*;
import com.ecouv.EcoUv.repository.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogos")
@CrossOrigin(origins = "*")
public class CatalogController {

    private final FacultadRepository facultadRepository;
    private final CarreraRepository carreraRepository;
    private final PlanRepository planRepository;
    private final GrupoRepository grupoRepository;

    public CatalogController(
            FacultadRepository facultadRepository,
            CarreraRepository carreraRepository,
            PlanRepository planRepository,
            GrupoRepository grupoRepository
    ) {
        this.facultadRepository = facultadRepository;
        this.carreraRepository = carreraRepository;
        this.planRepository = planRepository;
        this.grupoRepository = grupoRepository;
    }

    // ==========================
    // 1. LISTAR FACULTADES
    // ==========================
    @GetMapping("/facultades")
    public ResponseEntity<?> obtenerFacultades() {
        List<Facultad> facultades = facultadRepository.findAll();
        return ResponseEntity.ok(facultades);
    }

    // ==========================
    // 2. CARRERAS POR FACULTAD
    // ==========================
    @GetMapping("/carreras/{facultadId}")
    public ResponseEntity<?> obtenerCarreras(@PathVariable Long facultadId) {

        Facultad facultad = facultadRepository.findById(facultadId)
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));

        List<Carrera> carreras = carreraRepository.findByFacultad(facultad);

        return ResponseEntity.ok(carreras);
    }

    // ==========================
    // 3. PLANES POR CARRERA
    // ==========================
    @GetMapping("/planes/{carreraId}")
    public ResponseEntity<?> obtenerPlanes(@PathVariable Long carreraId) {

        Carrera carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        List<Plan> planes = planRepository.findByCarrera(carrera);

        return ResponseEntity.ok(planes);
    }

    // ==========================
    // 4. GRUPOS POR CARRERA
    // ==========================
    @GetMapping("/grupos/{carreraId}")
    public ResponseEntity<?> obtenerGrupos(@PathVariable Long carreraId) {

        Carrera carrera = carreraRepository.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        // Aquí reemplazamos los métodos que causaban error
        List<Grupo> grupos = grupoRepository.findByCarrera(carrera);

        return ResponseEntity.ok(grupos);
    }

    // ==========================
    // 5. GRUPOS POR PLAN
    // ==========================
    @GetMapping("/grupos/plan/{planId}")
    public ResponseEntity<?> obtenerGruposPorPlan(@PathVariable Long planId) {

        Plan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));

        List<Grupo> grupos = grupoRepository.findByPlan(plan);

        return ResponseEntity.ok(grupos);
    }

}
